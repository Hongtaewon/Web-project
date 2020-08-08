package web.project.backend.repository;

import java.util.List;
import java.util.Optional;

import web.project.backend.orm.user;


public interface MemberRepository {
	
	user save(user member);
	
	Optional<user> findById(Long id);
	Optional<user> findByName(String name);
	
	List<user> findAll();

}
