package web.project.backend.orm;


import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@Entity(name="member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Member extends BaseEntity{
	
	@Column(nullable = false)
	@NonNull
	private String loginid; // 로그인 시 사용하는 아이디
	@Column(nullable = false)
	@NonNull
	private String name; // 사용자의 이름
	@Column(nullable = false)
	@NonNull
	private String nick_name; //서비스를 이용할 때 보여지는 이름
	@Column(nullable = false)
	@NonNull
	private String password; // 패스워드 bcrypt를 사용할 예정
	@Column(nullable = false)
	@NonNull
	private String email; //무분별한 id생성을 막기 위한 인증용
	@Column
	private int auth; // 인증했는지 확인
	@Column
	private int password_cnt; // 패스워드 입력 횟수
	@Column
	private LocalDateTime last_login_try_Date; // 마지막으로 로그인을 시도한 시간
	@Column
	private int is_lock; // 로그인 제한 여부
	@ColumnDefault("USER")
	private String role; // 권한
	
}
