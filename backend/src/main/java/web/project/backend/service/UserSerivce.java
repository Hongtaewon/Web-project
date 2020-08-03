package web.project.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.backend.dao.UserDao;
import web.project.backend.orm.User;




@Service
public class UserSerivce {
	
	@Autowired
	private UserDao userDao;
	
	public User getUser(String userid) {
		return userDao.findById(userid).get();
	}
	
	public User setUser(User user) {
		return userDao.save(user);
	}
}
