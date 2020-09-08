package web.project.backend.entity;

import javax.persistence.*;

import lombok.Getter;

@Getter
@Entity(name="blog_post")
public class Blog_post extends BaseEntity{
	
	@Column
	private Long blog_id; //블로그 아이디
	@Column
	private String title; //포스트 제목
	@Column
	private String subtitle; //포스트 부제목
	@Column 
	private Long author_id; //포스트 작성자
	@Column
	private int enabled; //포스트 숨김기능
	@Column
	private int views; //조회수
	@Column(columnDefinition = "TEXT", nullable = false)
    private String content;
	@Column
	private int likes; // post_like 테이블의 cnt를 해서 저장함.
	@Column
	private String tag; // tag는 ,로 구분

}
