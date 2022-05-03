package app.Domain.Entity;

import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "member")
@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class MemberEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mno;
	@Column
	private String mid;
	@Column
	private String mpw;
	@Column
	private String mname;
	@Column
	private String memail;
}
