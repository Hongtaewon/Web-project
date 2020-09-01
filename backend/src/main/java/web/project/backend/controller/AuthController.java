package web.project.backend.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
	public APIMessage<?> signUp(@RequestBody APIMessage<Member> message) {
		
		APIMessage<Member> response = memberService.signUp(message);
		
		return response;
	}
	@PostMapping("/signIn")
	public APIMessage<?> signIn(@RequestBody APIMessage<Member> message,
					            HttpServletRequest req,
					            HttpServletResponse res) {
		
		//memeberservie 계정 확인
		Member member = (Member) message.getBody().getAny();
		APIMessage<Cookie> response = new APIMessage<>("Token");
		try {
			
			final String token = jwtUtil.generateToken(member);
            final String refreshJwt = jwtUtil.generateRefreshToken(member);
            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
            redisUtil.setDataExpire(refreshJwt, member.getLoginid(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
            res.addCookie(accessToken);
            res.addCookie(refreshToken);
            return response;
		} catch (Exception e) {
            response.getReturn().setReason(HttpStatus.UNAUTHORIZED.toString());
            return response;
        }
	}
	
	@PostMapping("/info")
    //@PreAuthorize("hasRole('USER')")
    public APIMessage<?> getCurrentUser(@CurrentUser MyUserDetails myUserDetails) {
		System.out.println(myUserDetails);
        //log.debug("REST request to get user : {}", CustomUserDetails.getEmail());
		APIMessage<Member> response = new APIMessage<>("Member");
		
		Member member = memberService.findOne(myUserDetails.getUsername())
				.orElseThrow(() ->
                new UsernameNotFoundException("User not found with loginId : " + myUserDetails.getId()));
		response.getBody().setAny(member);
        return response;
    }
}
