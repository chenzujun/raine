package com.jun.raine.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.raine.bean.User;
import com.jun.raine.service.UserService;

public class TestHibernate {

	@Test
	public void test() {
		ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");

		User user = new User();
		user.setName("jim");
		user.setPassword("1");
		userService.save(user);
	}
}
