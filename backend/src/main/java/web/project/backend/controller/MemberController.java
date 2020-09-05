package web.project.backend.controller;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import web.project.backend.orm.Member;
import web.project.backend.service.MemberService;
import web.project.backend.util.message.APIMessage;

@RestController
@RequestMapping("blog/member")
@Log4j2
public class MemberController {

	@Autowired
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/members")
	public List<Member> list(Model model) {
		
		List<Member> members = memberService.findMembers();
		model.addAttribute("members",members);
		
		return members;
	}
	
}
