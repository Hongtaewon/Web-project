package web.project.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.project.backend.orm.Member;

@Repository
public interface JpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {


	Optional<Member> findByloginid(String id);
}
