package com.jun.raine.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.raine.service.UserService;

public class TestSpring {
	
	@Test
	public void test() {
		ApplicationContext ac = new  ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) ac.getBean("userService");
		userService.selectAll();
	}
}
