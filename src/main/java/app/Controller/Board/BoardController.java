package app.Controller.Board;

import app.Domain.Dto.Board.BoardDto;
import app.Domain.Dto.Member.MemberDto;
import app.Service.Board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Controller
public class BoardController {

    @Autowired
    BoardService boardService; // boardservice 메소드 호출용 객체
    @Autowired  // 빈 생성
    HttpServletRequest request; // 요청객체
    @Autowired
    HttpServletResponse response; // 응답객체

    // http url 연결
    // 게시물 전체 목록 페이지 이동
    @GetMapping("/board/boardlist")
    public String boardlist(Model model) {
        ArrayList<BoardDto> boardDtos = boardService.boardlist();

      /*  // 검색처리 서비스
        String keyword = request.getParameter("keyword");
        String search = request.getParameter("search");

        HttpSession session = request.getSession();
        if(keyword != null || search != null){ // 검색이 있으면
            session.setAttribute("keyword",keyword);
            session.setAttribute("search",search);

        } else { // 검색이 없으면
            keyword = (String)session.getAttribute("keyword");
            search =  (String)session.getAttribute("search");

        }*/
        /*// 페이징 처리 서비스
        Page<BoardEntity> boardDtos = boardService.boardlist(pageable,keyword,search);*/
        model.addAttribute("boardDtos", boardDtos);

        return "board/boardlist";  // 타임리프 를 통한 html 반환
    }

    // 게시물 쓰기 페이지 이동
    @GetMapping("/board/boardwrite")
    public String boardwrite() {

        return "board/boardwrite"; // html을 반환해주는 기능
    }


    // 게시물 쓰기 처리(이동X)
    @PostMapping("/board/boardwritecontroller")
    @ResponseBody
    public int boardwritecontroller(@RequestParam("b_img") MultipartFile file) {

        try {
            String uuidfile = null;
            if (!file.getOriginalFilename().equals("")) { // 첨부파일이 있을때
                // 파일처리[jsp:cos 라이브러리 / spring: MultipartFile 인터페이스 포함되있음]
                String dir = "C:\\Users\\ezr210310\\Desktop\\SpringWeb\\src\\main\\resources\\static\\upload"; // 저장경로
                //String dir = "\\home\\ec2-user\\java\\SpringWeb\\src\\main\\resources\\static\\upload"; //리눅스경로

                // 만약에 사용자가 파일명에 _ 입력하면 -로 저장
                String OriginalFilename = file.getOriginalFilename();
                // 파일 이름 중복배제 [UUID: 고유식별자]
                UUID uuid = UUID.randomUUID(); // 고유 식별자 객체 난수 생성 메소드 호출
                // LocalDateTime localDateTime = LocalDateTime.now(); // 시간으로 식별
                //  = String uuidfile = localDateTime+"_"+file.getOriginalFilename();

                uuidfile = uuid.toString() + "_" + OriginalFilename.replaceAll("_", "-");
                // 고유식별자_파일명
                String filepath = dir + "\\" + uuidfile; // 저장경로 + form 에서 첨부한 파일이름 호출
                // file.getOriginalFilename() : form 첨부파일 호출
                file.transferTo(new File(filepath)); // transferTo : 파일저장 [예외처리가 있음]
            } else {
                uuidfile = null;
            }





          /*  // 제목, 내용 호출
            String b_title = request.getParameter("b_title");
            String b_contents = request.getParameter("b_contents");
            BoardDto boardDto = new BoardDto();
            boardDto.setB_title(b_title);
            boardDto.setB_contents(b_contents);
            boardDto.setB_img(file.getOriginalFilename()); // form에서 첨부한 파일이름 호출*/


            // 세션
            HttpSession session = request.getSession();
            // 담기 / 형변환
            MemberDto memberDto = (MemberDto) session.getAttribute("logindto");
            //boardDto.setB_writer(memberDto.getMid());

            BoardDto boardDto = BoardDto.builder().
                    b_title(request.getParameter("b_title"))
                    .b_contents(request.getParameter("b_contents"))
                    .b_writer(memberDto.getMid())
                    .b_img(uuidfile).build();


            boardService.boardwrite(boardDto);

            //return "redirect:/board/boardlist"; // 글쓰기 성공시 게시판 목록이동
            return 1;
        } catch (Exception e) {
            return 2;
        }
    }

    // 첨부파일 다운로드 처리
   /* @GetMapping("/board/filedownload/{b_img}")
    public void filedownload(@PathVariable("b_img") String b_img){}*/
    // 첨부파일 다운로드 처리
    @GetMapping("/board/filedownload")
    public void filedownload(@RequestParam("b_img") String b_img, HttpServletResponse response) {
        // 첨부파이리 경로 + 파일이름
        String path = "C:\\Users\\ezr210310\\Desktop\\SpringWeb\\src\\main\\resources\\static\\upload\\" + b_img; // 저장경로
        // 객체화
        // File file = new File(path);

        try {
            // 다운로드 html[창]
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(b_img.split("_")[1], "UTF-8"));
            // 영문X, 한글 URLEncoder.encode(파일명,"UTF-8")
            // 파일 객체 읽어오기
            OutputStream outputStream = response.getOutputStream();
            // 내보내기 할 대상 읽어오기 [파일 읽기] 출력 스트림
            FileInputStream fileInputStream = new FileInputStream(path);


            int read = 0;
            byte[] buffer = new byte[1024]; // 읽어올 바이트를 저장할 배열
            while ((read = fileInputStream.read(buffer)) != -1) { // 파일읽기[.read] 1024바이트씩 계속 읽어오면서 outputstream에 저장. -1이 나오면 더이상 읽을 파일이 없음.
                outputStream.write(buffer, 0, read); // 파일쓰기 [.write]

            }


        } catch (IOException e) {
            System.out.println("download error");
        }

    }


    // 게시물 보기 페이지 이동
    @GetMapping("/board/boardview/{b_num}") // GET 방식으로 URL 매핑[연결]
    public String boardview(@PathVariable("b_num") int b_num, Model model) {
        // @PathVariable : 경로상에서  data 빼옴
        BoardDto boardDto = boardService.getBoard(b_num);
        // 첨부파일 존재하면 uuid가 제거된 파일명 변환해서 b_realimg 담기
        if (boardDto.getB_img() != null) boardDto.setB_realimg(boardDto.getB_img().split("_")[1]);

        model.addAttribute("boardDto", boardDto);
/*
        // 해당 게시물번호의 댓글 호출
        List<ReplyEntity> replyEntities = boardService.getreplylist(b_num);
        // 정렬후 => 내림차순
        Collections.reverse(replyEntities);

        model.addAttribute("replyEntities", replyEntities);*/
        return "board/boardview";
        // 타임리프를 이용한 html 반환


    }

    // 게시물 삭제 처리
    @GetMapping("/board/boarddelete")
    @ResponseBody
    public int boarddelete(@RequestParam("b_num") int b_num) {
        // @RequestParam("b_num") int b_num 사용안할 시 int b_num = request.getParameter("b_num");

        boolean result = boardService.delete(b_num);
        if (result) {
            return 1;
        } else {
            return 2;
        }
    }

    // 게시물 수정 페이지 이동 (@GetMapping("/board/boardupdate/{변수}/{변수}") => 변수 여러개 사용가능)
    @GetMapping("/board/boardupdate/{b_num}")
    public String boardupdate(@PathVariable("b_num") int b_num, Model model) {
        BoardDto boardDto = boardService.getBoard(b_num);
        if (boardDto.getB_img() != null) boardDto.setB_realimg(boardDto.getB_img().split("_")[1]);
        model.addAttribute("boardDto", boardDto); // 프론트에게 넘길거라 만들어줘야함.


        return "board/boardupdate"; // html 열기
    }

    // 수정 처리
    @PostMapping("/board/boardcontroller")
    public String boardcontroller(@RequestParam("b_newimg") MultipartFile file,
                                  @RequestParam("b_num") int b_num,
                                  @RequestParam("b_title") String b_title,
                                  @RequestParam("b_contents") String b_contents,
                                  @RequestParam("b_img") String b_img) {
        // 자동 주입 사용
        /*
            자동 주입 미사용
            int b_num = Integer.parseInt(request.getParameter("b_num"));
            String b_title = request.getParameter("b_title");
            String b_contents = request.getParameter("b_contents");
            BoardDto boardDto = new BoardDto();
            boardDto.setB_num(b_num);
            boardDto.setB_title(b_title);
            boardDto.setB_contents(b_contents);
        */


        if (!file.getOriginalFilename().equals("")) { //변경된 첨부파일 존재
            try {
                String dir = "C:\\Users\\ezr210310\\Desktop\\SpringWeb\\src\\main\\resources\\static\\upload"; // 저장경로
                UUID uuid = UUID.randomUUID();
                String uuidfile = uuid.toString() + "_" + file.getOriginalFilename().replaceAll("_", "-");
                String filepath = dir + "\\" + uuidfile;
                file.transferTo(new File(filepath));
                boardService.update(
                        BoardDto.builder()
                                .b_num(b_num)
                                .b_contents(b_contents)
                                .b_title(b_title)
                                .b_img(uuidfile).build()

                );
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (file.getOriginalFilename().equals("")) {
            boardService.update(
                    BoardDto.builder()
                            .b_num(b_num)
                            .b_contents(b_contents)
                            .b_title(b_title)
                            .build()

            );
        } else { //변경된 첨부파일 없음. 기존파일 그대로 사용
            boardService.update(
                    BoardDto.builder()
                            .b_num(b_num)
                            .b_contents(b_contents)
                            .b_title(b_title)
                            .b_img(b_img).build()

            );
        }

        return "redirect:/board/boardview/" + b_num;
        /*
            return "반환타입" // 일반java : 반환타입이 반환
            return "html파일명";  // 타임리프가 해당 html 반환
            return "객체명" // @ResponseBody 사용시 객체 반환
            return "redirect:URL"; // 해당 URL 반환
            return "redirect:/board/boardlist/"+ boardDto.getB_num();
        */


    }
}