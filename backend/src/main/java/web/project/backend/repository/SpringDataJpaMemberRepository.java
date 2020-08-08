package web.project.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.backend.orm.user;

public interface SpringDataJpaMemberRepository extends JpaRepository<user, Long>, MemberRepository {

	@Override
	Optional<user> findByName(String name);
}
