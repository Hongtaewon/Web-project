package web.project.backend.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.project.backend.orm.Member;
import web.project.backend.service.MemberService;
import web.project.backend.util.message.APIMessage;

@RestController
@RequestMapping("blog/member")
public class MemberController {

	@Autowired
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@PostMapping("/signUp")
	public APIMessage<?> signUp(@RequestBody APIMessage<Member> message) {
		
		APIMessage<Member> response = memberService.signUp(message);
		
		return response;
	}
	@PostMapping("/signIn")
	public APIMessage<?> signIn(@RequestBody APIMessage<Member> message) {
		
		APIMessage<Member> response = memberService.signIn(message);
		
		return response;
	}
	
	@GetMapping("/members")
	public List<Member> list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members",members);
		
		return members;
	}
}
