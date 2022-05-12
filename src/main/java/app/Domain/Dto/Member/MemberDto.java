package app.Domain.Dto.Member;

import app.Domain.Entity.Member.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 풀생성자
@Getter // get 메소드
@Setter // set 메소드
@ToString // 객체정보 메소드
@Builder
public class MemberDto {
    // 필드 // private => 은닉화
    private int m_num; // 회원번호
    private String mid; // 회원id
    private String m_pw; // 회원pw
    private String m_name; // 회원이름
    private String m_sex; // 회원성별
    private String m_phone; // 회원연락처
    private String memail; // 회원이메일
    private String m_address; // 회원주소
    private int m_point; // 회원포인트
    private String m_grade; // 회원등급
    private LocalDateTime m_createdDate;

    // 생성자

    //메소드

    // Dto -> Entity 변환 메소드
   /* public MemberEntity toentity(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setM_id(this.m_id);
        memberEntity.setM_pw(this.m_pw);
        memberEntity.setM_name(this.m_name);
        memberEntity.setM_sex(this.m_sex);
        memberEntity.setM_phone(this.m_phone);
        memberEntity.setM_email(this.m_email);
        memberEntity.setM_address(this.m_address);
        return memberEntity;
    }*/

    public MemberEntity toentity(){
        return MemberEntity.builder()
                .mid(this.mid)
                .m_pw(this.m_pw)
                .m_name(this.m_name)
                .m_sex(this.m_sex)
                .m_phone(this.m_phone)
                .memail(this.memail)
                .m_address(this.m_address)
                .m_point(this.m_point)
                .m_grade(this.m_grade).build();
    }
}
