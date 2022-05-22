package app.Service;

import app.Entity.BoardEntity;
import app.Exception.ResourceNotFoundException;
import app.Repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public List<BoardEntity> get() {

        System.out.println("게시판 메소드 실행");
        List<BoardEntity> b_list = boardRepository.findAll();
        return b_list;
    }

    public BoardEntity createBoard(BoardEntity board) {
        return boardRepository.save(board);
    }

    public ResponseEntity<BoardEntity> getBoard(Integer no) {
        BoardEntity board = boardRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+no+"]"));
        return ResponseEntity.ok(board);
    }
}
