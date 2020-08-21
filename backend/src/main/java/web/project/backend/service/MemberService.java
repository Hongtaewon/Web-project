package web.project.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.project.backend.orm.Member;
import web.project.backend.repository.MemberRepository;
import web.project.backend.util.message.APIMessage;


@Transactional
@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	private boolean validateDubplicateMember(Member member) {
		return memberRepository.findByloginid(member.getLoginid()).isPresent();
	}
	
	private boolean validateLoginMemberInfo(Member member) {
		Member m = memberRepository.findByloginid(member.getLoginid())
										.orElse(null);
		
		//member가 없음
		if(m.equals(null))
			return false;
		else
		{
			if(member.getPassword().equals(m.getPassword()))
				return true;
			else
				return false;
		}
	}
	
	/*
	 * 회원 가입
	 * */
	public APIMessage<Member> signUp(APIMessage<Member> message) {
		//같은 이름이 있는 중복 회원 x
		Member member = (Member) message.getBody().getAny();
		
		if(validateDubplicateMember(member))
		{
			message.getReturn().setResult(HttpStatus.ACCEPTED.toString());
			message.getReturn().setReason("아이디가 중복됩니다.");
		}
		else
		{
			memberRepository.save(member);
			message.getReturn().setResult(HttpStatus.OK.toString());
		}
		
		return message;
	}
	
	/*
	 * 로그인
	 * */
	public APIMessage<Member> signIn(APIMessage<Member> message) {
		
		Member member = (Member) message.getBody().getAny();
		if(validateLoginMemberInfo(member))
		{
			message.getReturn().setResult(HttpStatus.OK.toString());
			//토큰 발행
		}
		else
		{
			message.getReturn().setResult(HttpStatus.ACCEPTED.toString());
			message.getReturn().setReason("아이디 또는 비밀번호가 틀렸습니다.");
		}
		
		return message;
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
