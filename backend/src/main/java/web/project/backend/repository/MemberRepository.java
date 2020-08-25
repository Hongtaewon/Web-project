package web.project.backend.repository;

import java.util.List;
import java.util.Optional;

import web.project.backend.orm.Member;


public interface MemberRepository {
	
	Member save(Member member);
	
	Optional<Member> findByloginid(String id);
	
	Optional<Member> findByidx(Long id);
	
	List<Member> findAll();
	
	void delete(Member member);
	
	


}
