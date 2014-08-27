package com.jun.raine.service;

import java.util.List;

import com.jun.raine.bean.User;

public interface UserService {

public List<User> selectAll();
	
	public User select(Long id);
	
	public void update(User user);
	
	public void save(User user);
	
	public void delete(Long id);
}
