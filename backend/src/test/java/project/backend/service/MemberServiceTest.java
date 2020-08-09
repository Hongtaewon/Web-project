/*package project.backend.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import web.project.backend.orm.user;
import web.project.backend.repository.MemoryMemberRepository;
import web.project.backend.service.MemberService;

class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void 회원가입() {
		//given
		user member = new user();
		member.setName("Spring");
		
		//when
		Long saveId = memberService.join(member);
		//then
		user findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		user member1 = new user();
		member1.setName("Spring");
		
		user member2 = new user();
		member2.setName("Spring");
		//when
		memberService.join(member1);
		
		IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
		try {
			memberService.join(member2);
			fail();
		} catch (IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
			// TODO: handle exception
		}
		//then
	}

}
*/