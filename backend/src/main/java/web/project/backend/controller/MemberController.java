package web.project.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import web.project.backend.orm.Member;
import web.project.backend.service.MemberService;
import web.project.backend.util.message.APIMessage;

@RestController
public class MemberController {

	@Autowired
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	

	@GetMapping("/members/new")
	public String createForm() {
		return "/members/createMemberForm";
	}
	
	@GetMapping("/test")
	public APIMessage<?> testing() {
		
		APIMessage<Member> test = new APIMessage<>("Member");
		
		Member member = new Member("11","22","33","44","55");
		
		test.getBody().setAny(member);
		
		return test;
	}
	
	@PostMapping("/test11")
	public void postTest(@RequestBody APIMessage<?> message) {
		
		
		System.out.println(message);
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member(form.getLoginid(), form.getName(), 
									form.getNick_name(), form.getPassword(), form.getEmail());
		
		memberService.join(member);
		
		return "redirect:/";
	}
	
	@GetMapping("/members/remove")
	public String removeForm() {
		return "/members/removeMemberForm";
	}
	
	@PostMapping("/members/remove")
	public String remove(MemberForm form) {
		Member member = memberService.findOne(form.getLoginid()).get();
		
		memberService.removeMember(member);
		
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public List<Member> list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members",members);
		
		return members;
	}
}
