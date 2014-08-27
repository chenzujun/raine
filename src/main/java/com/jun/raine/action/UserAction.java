package com.jun.raine.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jun.raine.bean.User;
import com.jun.raine.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/user")
@Results({
	@Result(name = "success", location = "/WEB-INF/content/success.jsp"),
	@Result(name = "user-list", location = "/WEB-INF/user/user-list.jsp"),
	@Result(name = "user-input", location = "/WEB-INF/user/user-input.jsp"),
	@Result(name = "error", location = "/WEB-INF/content/error.jsp")
})
@Action("userAction")
public class UserAction implements ModelDriven<User>, ServletRequestAware {

	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);
	
	@Autowired
	private UserService userService;
	
	public List<User> userList;
	
	public User user = new User();
	
	private HttpServletRequest request;
	
	public void test(){
		logger.info("进入 test");
		userService.selectAll();
	}
	
	public String list(){
		
		userList = userService.selectAll();
		
		return "user-list";
	}
	
	public String input(){
		
		String id = request.getParameter("id");
		user = userService.select(Long.parseLong(id));
		
		return "user-input";
	}
	
	public void delete(){
		
		list();
	}
	
	public void update(){
		
		//TODO update
		
		list();
	}

	@Override
	public User getModel() {

		return user;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {

		this.request = request;
	}
}
