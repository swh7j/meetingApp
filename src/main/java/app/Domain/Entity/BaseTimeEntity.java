package app.Domain.Entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class) // 검사
@MappedSuperclass
public class BaseTimeEntity {
    // 엔티티 생성/수정날자 자동주입
    @CreatedDate // 스프링에서 지원하는 현재 날짜,시간 주입
    private LocalDateTime createdDate; // 객체
    @LastModifiedDate // 수정 날짜,시간 주입
    private LocalDateTime modifiedDate;

}