package web.project.backend.orm;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;


@Getter
@Entity(name="comment_like")
public class Comment_like extends BaseEntity{
	
	@Column
	private Long comment_id;
	@Column
	private Long user_id;
}
