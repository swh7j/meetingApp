package app.Service.Board;

import app.Domain.Dto.Board.BoardDto;
import app.Domain.Entity.Board.BoardEntity;
import app.Domain.Entity.Board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    // 글쓰기메소드
    @Autowired
    BoardRepository boardRepository;

    public void boardwrite(BoardDto boardDto) {
        boardRepository.save(boardDto.toentity());

    }



    public ArrayList<BoardDto> boardlist() {
        // 게시물 번호를 정렬해서 엔티티 호출하기
        // SQL : Select * from board order by 필드명 DESC
        // JPA : boardRepository.findAll(Sort.by(Sort.Direction.DESC,"entity 필드명"))
        List<BoardEntity> boardEntities = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate")); // 모든 엔티티 호출
        ArrayList<BoardDto> boardDtos = new ArrayList<>(); // 모든 dto 담을 리스트 선언
        for (BoardEntity boardEntity : boardEntities) { // 모든 엔티티를 반복하면서 하나씩 꺼내오기
            // 날짜 형변환[localdate => String]
            // LocalDateTime.format((DateTimeFormatter.ofPattern("yy-MM-dd"));
            String date = boardEntity.getCreatedDate().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
            // 오늘날짜 출력[localdate => String]
            String nowdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
            // 만약에 게시물 작성일이 오늘이면 시간 출력, 아니면 날짜를 출력
            if (date.equals(nowdate)) {
                date = boardEntity.getCreatedDate().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
            }
            // 엔티티 => dto 변환
            BoardDto boardDto = new BoardDto(
                    boardEntity.getBnum(),
                    date,
                    boardEntity.getB_contents(),
                    boardEntity.getB_img(),
                    boardEntity.getB_title(),
                    boardEntity.getB_view(),
                    boardEntity.getB_writer(),
                    null);
            boardDtos.add(boardDto); // 리스트에 저장
        }
        return boardDtos;
    }


    @Autowired
    HttpServletRequest request;

    // 게시물 view 출력
    @Transactional
    public BoardDto getBoard(int b_num) {
        // findById("pk값") : 해당 pk의 엔티티를 호출 -> entityOptional
        Optional<BoardEntity> entityOptional = boardRepository.findById(b_num);
        String date = entityOptional.get().getCreatedDate().format(DateTimeFormatter.ofPattern("yy-MM-dd"));

        //[세션 이용한] 조회수 중복방지
        HttpSession session = request.getSession();


        if (session.getAttribute(b_num + "") == null) { //만약에 기존에 조회수 증가를 안했으면
            // 조회수 변경
            entityOptional.get().setB_view(entityOptional.get().getB_view() + 1);
            // 세션부여
            session.setAttribute(b_num + "", 1); // b_num+"" string이라 문자처리
            //해당 세션시간
            session.setMaxInactiveInterval(60 * 60 * 24); // 1일

        }


        return BoardDto.builder() // buider에 미입력시 자동 null값 주입
                .b_num(entityOptional.get().getBnum())
                .b_createdDate(date)
                .b_contents(entityOptional.get().getB_contents())
                .b_title(entityOptional.get().getB_title())
                .b_view(entityOptional.get().getB_view())
                .b_img(entityOptional.get().getB_img())
                .b_writer(entityOptional.get().getB_writer())
                .build();

    }

    // 게시물 삭제처리
    public boolean delete(int b_num) {
        Optional<BoardEntity> entityOptional = boardRepository.findById(b_num);
        if (entityOptional.get() != null) {
            boardRepository.delete(entityOptional.get());
            return true;
        } else {
            return false;
        }
    }

    // 게시물 수정 처리
    @Transactional // 수정중 오류 발생시 rollback : 취소
    public boolean update(BoardDto boardDto) {
        try {
            // 1. 수정할 엔티티 찾는다
            Optional<BoardEntity> entityOptional = boardRepository.findById(boardDto.getB_num());
            // 2. 엔티티를 수정한다[엔티티변화=>DB변경]
            entityOptional.get().setB_title(boardDto.getB_title());
            entityOptional.get().setB_contents(boardDto.getB_contents());
            entityOptional.get().setB_img(boardDto.getB_img());
            return true;
        } catch (Exception e) {

            System.out.println(e);
            return false;
        }
    }
}
