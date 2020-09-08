package web.project.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import web.project.backend.entity.Blog_post;
import web.project.backend.service.PostService;
import web.project.backend.util.message.APIMessage;

@RestController
@RequestMapping("blog/blog-post")
@Log4j2
public class PostController {

	@Autowired
	private final PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/1")
	public APIMessage<?> getPost() {
		Long a = (long) 1;
		Blog_post post = postService.post(a);
		APIMessage<Blog_post> message = new APIMessage<>("blog-post");
		message.getBody().setAny(post);
		
		return message;
	}
}
