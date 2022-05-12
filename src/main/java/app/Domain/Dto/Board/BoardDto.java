package app.Domain.Dto.Board;


import app.Domain.Entity.Board.BoardEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {

    private int b_num;
    private String b_createdDate;
    private String b_contents;
    private String b_img; // 경로
    private String b_title;
    private int b_view;
    private String b_writer;
    private String b_realimg; // 파일명


    // dtd-> entity
    public BoardEntity toentity(){
        return BoardEntity.builder()
                .b_title(this.b_title)
                .b_contents(this.b_contents)
                .b_writer(this.b_writer)
                .b_img(this.b_img)
                .build();
    }
}