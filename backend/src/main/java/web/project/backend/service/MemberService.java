package web.project.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

import web.project.backend.orm.user;
import web.project.backend.repository.MemberRepository;


@Transactional
public class MemberService {

	private final MemberRepository memberRepository;
	

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/*
	 * 회원 가입
	 * */
	public Long join(user member) {
		//같은 이름이 있는 중복 회원 x
		validateDubplicateMember(member);
		
		
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDubplicateMember(user member) {
		memberRepository.findByName(member.getName())
				.ifPresent(m -> {
					throw new IllegalStateException("이미 존재하는 회원입니다.");
				});
	}
	
	/*
	 * 전체 회원 조회
	 * */
	public List<user> findMembers() {
		return memberRepository.findAll();
	}
	
	public Optional<user> findOne(Long memberId) {
		return memberRepository.findById(memberId);	
	}

}
