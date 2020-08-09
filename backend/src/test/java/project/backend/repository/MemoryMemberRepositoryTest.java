/*package project.backend.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import web.project.backend.orm.user;
import web.project.backend.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	@Test
	public void save() {
		user member = new user();
		member.setName("spring");
		
		repository.save(member);
		
		user result = repository.findById(member.getId()).get();
		
		assertThat(member).isEqualTo(result);
		
	}
	
	@Test
	public void FindbyName() {
		user member1 = new user();
		member1.setName("spring1");
		repository.save(member1);
		

		user member2 = new user();
		member2.setName("spring2");
		repository.save(member2);
		
		user result = repository.findByName("spring1").get();
		
		assertThat(result).isEqualTo(member1);
	}
	
	@Test
	public void findAll() {
		user member1 = new user();
		member1.setName("spring1");
		repository.save(member1);
		

		user member2 = new user();
		member2.setName("spring2");
		repository.save(member2);
		
		List<user> result = repository.findAll();
		assertThat(result.size()).isEqualTo(2);
		
	}
}
*/