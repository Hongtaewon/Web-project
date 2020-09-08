package web.project.backend.entity;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;


/*
 * 필요한 테이블에 기본으로 적용하는 Entity
 * 
 * index, createdDate, ModifiedDate
 * 
 * */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	@CreatedDate
	private LocalDateTime CreatedDate;
	@LastModifiedDate
	private LocalDateTime ModifiedDate;
}
