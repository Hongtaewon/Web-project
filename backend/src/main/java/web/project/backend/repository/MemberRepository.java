package web.project.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import web.project.backend.orm.Member;


public interface MemberRepository {
	
	Member save(Member member);
	
	Optional<Member> findByloginid(String id);
	
	List<Member> findAll();
	
	void delete(Member member);
	
	


}
