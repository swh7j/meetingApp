package app.Domain.DTO;

import app.Domain.Entity.MemberEntity;
import lombok.*;

import java.lang.reflect.Member;

@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class MemberDTO {
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private String memail;

	MemberEntity memberEntity = MemberEntity.builder()
		.mid(this.mid)
		.mpw(this.mpw)
		.mname(this.mname)
		.memail(this.memail)
		.build();;
}
