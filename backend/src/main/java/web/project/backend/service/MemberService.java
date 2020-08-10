package web.project.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.project.backend.orm.Member;
import web.project.backend.repository.MemberRepository;


@Transactional
@Service
public class MemberService {

	@Autowired
	private final MemberRepository memberRepository;
	
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/*
	 * 회원 가입
	 * */
	public String join(Member member) {
		//같은 이름이 있는 중복 회원 x
		validateDubplicateMember(member);
		
		memberRepository.save(member);
		
		return member.getLoginid();
	}

	private void validateDubplicateMember(Member member) {
		memberRepository.findByloginid(member.getLoginid())
				.ifPresent(m -> {
					throw new IllegalStateException("이미 존재하는 회원입니다.");
				});
	}
	
	/*
	 * 전체 회원 조회
	 * */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(String memberId) {
		return memberRepository.findByloginid(memberId);	
	}
	
	public void removeMember(Member member) {
		
		memberRepository.delete(member);
	}

}
