package com.jun.raine.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.jun.raine.bean.User;
import com.jun.raine.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory; 
	
	
	@Override
	public List<User> selectAll() {

		String sql = "select * from user";
		return this.getCurrentSession().createSQLQuery(sql).addEntity(User.class).list();
	}

	@Override
	public User select(Long id){
		
		return (User) this.getCurrentSession().get(User.class, id);
	}
	
	@Override
	public void update(User user) {

		this.getCurrentSession().update(user);
	}

	@Override
	public Serializable save(User user) {
		
		return this.getCurrentSession().save(user);
	}
	
	@Override
	public void delete(Long id){
		
		this.getCurrentSession().delete(id);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}


}
