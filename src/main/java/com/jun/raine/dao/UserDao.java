package com.jun.raine.dao;

import java.io.Serializable;
import java.util.List;

import com.jun.raine.bean.User;

public interface UserDao {

	public List<User> selectAll();
	
	public User select(Long id);
	
	public void update(User user);
	
	public Serializable save(User user);
	
	public void delete(Long id);
}
