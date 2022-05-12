package app.Domain.Entity.Member;

import app.Domain.Entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity // 기본키 pk
@Table(name="member") // 테이블 속성
@Builder // 생성자의 안정성 보장
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberEntity extends BaseTimeEntity {
    @Id // Db내 테이블과 연결
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto key
    private int m_num; // 회원번호
    @Column
    private String mid; // 회원id
    @Column
    private String m_pw; // 회원pw
    @Column
    private String m_name; // 회원이름
    @Column
    private String m_sex; // 회원성별
    @Column
    private String m_phone; // 회원연락처
    @Column
    private String memail; // 회원이메일
    @Column
    private String m_address; // 회원주소
    @Column
    private String m_grade; // 회원등급
    @Column
    private int m_point; // 회원포인트
}