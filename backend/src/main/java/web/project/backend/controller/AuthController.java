package web.project.backend.controller;

import java.util.Collections;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.project.backend.orm.Member;
import web.project.backend.security.CookieUtil;
import web.project.backend.security.CurrentUser;
import web.project.backend.security.RedisUtil;
import web.project.backend.security.jwt.JwtUtil;
import web.project.backend.security.service.MyUserDetails;
import web.project.backend.service.MemberService;
import web.project.backend.util.message.APIMessage;

@RestController
@RequestMapping("blog/Auth")
public class AuthController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CookieUtil cookieUtil;
	@Autowired
	private RedisUtil redisUtil;
	
	@PostMapping("/signUp")
	public ResponseEntity<?> signUp(@RequestBody APIMessage<Member> message) {
		
		try{
			if(!memberService.signUp(message))
			{
				throw new Exception("이미 가입된 아이디입니다.");
			}
			return ResponseEntity.ok("가입완료");
		} catch (Exception e) {
			return new ResponseEntity<>(Collections.singletonMap("SignInErrorException",
                    e.getLocalizedMessage()), HttpStatus.CONFLICT);
		}
		
	}
	@PostMapping("/signIn")
	public APIMessage<?> signIn(@RequestBody APIMessage<Member> message,
					            HttpServletRequest req,
					            HttpServletResponse res) throws AuthenticationException {
		
		APIMessage<Cookie> response = new APIMessage<>("Token");
		
		if(memberService.signIn(message))
		{
			try {
				Member member = (Member) message.getBody().getAny();
				final String token = jwtUtil.generateToken(member);
	            final String refreshJwt = jwtUtil.generateRefreshToken(member);
	            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
	            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
	            redisUtil.setDataExpire(refreshJwt, member.getLoginid(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
	            res.addCookie(accessToken);
	            res.addCookie(refreshToken);
	            response.getReturn().setReason(HttpStatus.OK.toString());
	            return response;
			} catch (Exception e) {
	            response.getReturn().setReason(HttpStatus.UNAUTHORIZED.toString());
	            return response;
	        }
		}
		else
		{
			response.getReturn().setReason(HttpStatus.UNAUTHORIZED.toString());
            return response;
		}
	}
	
	@PostMapping("/info")
    //@PreAuthorize("hasRole('USER')")
    public APIMessage<?> getCurrentUser(@CurrentUser MyUserDetails myUserDetails) {
		System.out.println(myUserDetails);
        //log.debug("REST request to get user : {}", MyUserDetails.getEmail());
		APIMessage<Member> response = new APIMessage<>("Member");
		
		Member member = memberService.findOne(myUserDetails.getUsername())
				.orElseThrow(() ->
                new UsernameNotFoundException("User not found with loginId : " + myUserDetails.getId()));
		response.getBody().setAny(member);
        return response;
    }
}
