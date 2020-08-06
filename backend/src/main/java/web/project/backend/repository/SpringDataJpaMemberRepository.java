package web.project.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.backend.orm.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

	@Override
	Optional<Member> findByName(String name);
}
