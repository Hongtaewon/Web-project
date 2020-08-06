package web.project.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.project.backend.repository.MemberRepository;
import web.project.backend.service.MemberService;
import web.project.backend.util.TimeTraceAop;

@Configuration
public class SpringConfig {

	/*private DataSource dataSource;
	

	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	/*@PersistenceContext
	private EntityManager em;
	
	@Autowired
	public SpringConfig(EntityManager em)
	{
		this.em = em;
	}*/
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
/*	@Bean
	public MemberRepository memberRepository() {
		
		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		//return new JdbcTemplateMemberRepository(dataSource);
		//return new JpaMemberRepository(em);
	}*/
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
}
