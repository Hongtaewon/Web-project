package web.project.backend.orm;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity(name="comment")
public class Post_comment extends BaseEntity {
	
	@Column
	private Long post_id; //포스트 아이디
	@Column
	private Long user_id; //코멘트를 단 유저 아이디
	@Column
	private boolean enabled; //숨김 기능
	@Column
	private String comment; //코멘트 내용
	@Column
	private int like; //좋아요. comment_like를 cnt해서 저장함.
	

}
