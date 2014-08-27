package com.jun.raine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jun.raine.bean.User;
import com.jun.raine.dao.UserDao;
import com.jun.raine.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserDao userDao;
	
	@Override
	public List<User> selectAll() {

		return userDao.selectAll();
	}
	
	public User select(Long id){
		
		return userDao.select(id); 
	}

	@Override
	public void update(User user) {

		userDao.update(user);
	}
	
	public void save(User user){
		userDao.save(user);
	}
	
	public void delete(Long id){
		
		userDao.delete(id);
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
