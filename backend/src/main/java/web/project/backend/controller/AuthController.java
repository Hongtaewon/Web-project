package web.project.backend.controller;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.project.backend.orm.Member;
import web.project.backend.security.CookieUtil;
import web.project.backend.security.jwt.JwtUtil;
import web.project.backend.service.MemberService;
import web.project.backend.util.message.APIMessage;

@RestController
@RequestMapping("blog/Auth")
public class AuthController {

	@Autowired
	private final MemberService memberService;
	@Autowired
	private final JwtUtil jwtUtil;
	@Autowired
	private final CookieUtil cookieUtil;
	
	@Autowired
	public AuthController(MemberService memberService,JwtUtil jwtUtil,CookieUtil cookieUtil) {
		this.memberService = memberService;
		this.jwtUtil = jwtUtil;
		this.cookieUtil = cookieUtil;
	}
	
	@PostMapping("/signUp")
	public APIMessage<?> signUp(@RequestBody APIMessage<Member> message) {
		
		APIMessage<Member> response = memberService.signUp(message);
		
		return response;
	}
	@PostMapping("/signIn")
	public APIMessage<?> signIn(@RequestBody APIMessage<Member> message) {
		
		Member member = (Member) message.getBody().getAny();
		APIMessage<Member> response = memberService.signIn(message);
		try {
			
			final String token = jwtUtil.generateToken(member);
            final String refreshJwt = jwtUtil.generateRefreshToken(member);
            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
            
            System.out.println("accessToken: "+ accessToken);
            System.out.println("refreshToken: "+refreshToken);
            /*redisUtil.setDataExpire(refreshJwt, member.getName(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
            res.addCookie(accessToken);
            res.addCookie(refreshToken);*/
            
		} catch (Exception e) {
            
        }
		finally {

		}

		return response;
	}
	
	@GetMapping("/signIn")
	public APIMessage<?> signIn() {
		
		Member member = memberService.findOne("12").get();
		APIMessage<Member> message = new APIMessage<>("Member");
		
		message.getBody().setAny(member);
		
		APIMessage<Member> response = memberService.signIn(message);
		try {
			
			final String token = jwtUtil.generateToken(member);
            final String refreshJwt = jwtUtil.generateRefreshToken(member);

            System.out.println("token: "+ token);
            System.out.println("refreshJwt: "+ refreshJwt);
            
            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
            
            System.out.println("accessToken: "+ accessToken);
            System.out.println("refreshToken: "+ refreshToken);
            /*redisUtil.setDataExpire(refreshJwt, member.getName(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
            res.addCookie(accessToken);
            res.addCookie(refreshToken);*/
            
		} catch (Exception e) {
            System.out.println(e.getMessage());
        }
		finally {

		}

		return response;
	}
}
