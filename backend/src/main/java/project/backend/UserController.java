package project.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class UserController {
	
	
	
	private UserDao userDao;
	
	@RequestMapping(path="/add")
	public @ResponseBody String addNewUser ()
	{
		String id = "test";
		String name = "hong";
		String phone_number = "010-1111-1111";
		String email = "test@exam.com";
		userDto n = new userDto(1,id, name, phone_number, email);
		
		userDao.save(n);
		
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<userDto> getAllUsers() {
	    // This returns a JSON or XML with the users
		
		
	    return userDao.findAll();
	}

}
