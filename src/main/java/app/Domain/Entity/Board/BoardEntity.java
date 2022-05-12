package app.Domain.Entity.Board;

import lombok.*;
import app.Domain.Entity.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardEntity  extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bnum")
    private int bnum;
    @Column(name = "b_title")
    private String b_title;
    @Column(name = "b_contents", columnDefinition = "LongTEXT") // 썸머노트 내용에 사진이 들어갈 경우에 바이트가 커야함.
    private String b_contents;
    @Column(name = "b_writer")
    private String b_writer;
    @Column(name = "b_view")
    private int b_view;
    @Column(name = "b_img")
    private String b_img;

    // 여러개 댓글을 저장하는 리스트
    //@OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL)
    //private List<ReplyEntity> replyEntities = new ArrayList<>();
}