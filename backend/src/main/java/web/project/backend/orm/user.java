package web.project.backend.orm;


import javax.persistence.*;


import lombok.Getter;

@Getter
@Entity(name="user")
public class user extends BaseEntity{
	
	
	@Column(nullable = false)
	private String id; // 로그인 시 사용하는 아이디
	@Column(nullable = false)
	private String name; // 사용자의 이름
	@Column(nullable = false)
	private String nick_name; //서비스를 이용할 때 보여지는 이름
	@Column(nullable = false)
	private String password; // 패스워드 bcrypt를 사용할 예정
	@Column(nullable = false)
	private String email; //무분별한 id생성을 막기 위한 인증용
}
