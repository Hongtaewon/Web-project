package web.project.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.project.backend.orm.User;
import web.project.backend.service.UserSerivce;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserSerivce userService;
	
	
	@PostMapping("signin")
	public User signin(@RequestBody User reqBody) {
		String userId = reqBody.getId();
		User user = userService.getUser(userId);
		return user;
	}
	
}
