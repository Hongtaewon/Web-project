package web.project.backend.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import web.project.backend.orm.Member;


public class JpaMemberRepository implements MemberRepository {
	
	@PersistenceContext
	private final EntityManager em;
	
	@Autowired
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = em.createQuery("select m from Member m where m.name = :name",Member.class)
							.setParameter("name", name)
							.getResultList();
		return result.stream().findAny();
	}

	@Override
	public List<Member> findAll() {
		List<Member> result = em.createQuery("select m from Member m",Member.class)
								.getResultList();
		
		return result;
	}

}
