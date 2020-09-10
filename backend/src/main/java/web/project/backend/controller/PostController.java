package web.project.backend.controller;

import java.nio.file.FileSystems;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import web.project.backend.entity.Blog_post;
import web.project.backend.security.CurrentUser;
import web.project.backend.security.service.MyUserDetails;
import web.project.backend.service.PostService;
import web.project.backend.util.message.APIMessage;

@RestController
@RequestMapping("blog")
@Log4j2
public class PostController {
	
	@Autowired
	private PostService postService;

	
	
	/*@GetMapping("/{id}")
	public APIMessage<?> getPost(@PathVariable Long id) {
		Long a = (long) 1;
		Blog_post post = postService.post(a);
		APIMessage<Blog_post> message = new APIMessage<>("blog-post");
		message.getBody().setAny(post);
		
		return message;
	}*/
	
	@GetMapping("/{blogid}/post/{postid}")
	public APIMessage<?> getPost(@PathVariable Long blogid,
									@PathVariable Long postid)
	{
		APIMessage<Blog_post> message = new APIMessage<>("blog_post");
		
		Blog_post post = postService.getPost(blogid, postid);
		
		message.getBody().setAny(post);
		
		return message;
		
	}
	
	@PostMapping(value = "/postwrite")
    public ResponseEntity<?> registerPost(@CurrentUser MyUserDetails myUserDetails,
    										@RequestBody Blog_post post) throws Exception {
		
		Long testUserId = (long) 1;
		
		if(postService.RegisterPost(testUserId, post))
		{
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
    }
}
