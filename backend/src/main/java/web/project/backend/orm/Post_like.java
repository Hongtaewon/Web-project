package web.project.backend.orm;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;


@Getter
@Entity(name="post_like")
public class Post_like {
	
	@Column
	private Long post_id; // 포스트 아이디
	@Column
	private Long user_id; // 유저 아이디
}
