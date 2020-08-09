package web.project.backend.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
	

	private String loginid; // 로그인 시 사용하는 아이디
	private String name; // 사용자의 이름
	private String nick_name; //서비스를 이용할 때 보여지는 이름
	private String password; // 패스워드 bcrypt를 사용할 예정
	private String email; //무분별한 id생성을 막기 위한 인증용

	

}