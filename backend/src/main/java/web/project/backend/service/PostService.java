package web.project.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.project.backend.entity.Blog_post;
import web.project.backend.entity.Member;
import web.project.backend.repository.JpaBlogPostRepository;
import web.project.backend.repository.MemberRepository;


@Transactional
@Service
public class PostService {

	@Autowired
	private final JpaBlogPostRepository postRepository;
	
	
	public PostService(JpaBlogPostRepository postRepository) {
		this.postRepository = postRepository;
	}

	/*
	 * 포스트
	 * */
	public Blog_post post(Long id) {
		
		Blog_post post = postRepository.findById(id).get();
		
		return post;
	}

}
