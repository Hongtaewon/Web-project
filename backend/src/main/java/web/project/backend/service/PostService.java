package web.project.backend.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.project.backend.entity.Blog_post;
import web.project.backend.entity.Member;
import web.project.backend.repository.JpaBlogPostRepository;
import web.project.backend.repository.MemberRepository;
import web.project.backend.util.Base64Utils;


@Transactional
@Service
public class PostService {

	@Autowired
	private JpaBlogPostRepository postRepository;

	/*
	 * 포스트
	 * */
	public Blog_post post(Long id) {
		
		Blog_post post = postRepository.findById(id).get();
		
		return post;
	}
	
	/*
	 * 블로그에서 넘어온 값 저장
	 * 
	 * */
	public String RegisterPost(Long userIdx, String htmlcode) throws Exception {
		
		String[] saveData = StringUtils.split(htmlcode, "");
		
		System.out.println(saveData);
		
		byte[] test = Base64Utils.decodeBase64ToBytes(htmlcode);
		
		Path path = Paths.get("D:\\");
		
		System.out.println(test);
		try {
            Files.copy(new ByteArrayInputStream(test), path.resolve("test"));
            return path.resolve("test").toAbsolutePath().toString();
        } catch (Exception e) {
            throw new Exception();
        }
	}

}
