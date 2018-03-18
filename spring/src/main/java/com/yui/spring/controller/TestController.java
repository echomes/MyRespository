package com.yui.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yui.spring.cfg.Resource;
import com.yui.spring.entity.User;
import com.yui.spring.service.UserService;

/**
 * 测试
 * 
 * @author Echo
 *
 */
@RestController
public class TestController {

	@Autowired
	private Resource user;

	@Autowired
	private UserService userService;

	@RequestMapping("hello")
	public String hello(ModelMap map) {

		System.out.println(user);

		Resource u = new Resource();
		BeanUtils.copyProperties(user, u);
		map.put("user", user);
		return "index";
	}

	@RequestMapping("center")
	public String center(ModelMap map) {

		Resource u = new Resource();
		BeanUtils.copyProperties(user, u);
		u.setBirth(new Date());
		System.out.println(u);

		u.setDesc("<font color='red'>测试</font>");
		map.put("user", u);
		return "thymeleaf/index";
	}

	@RequestMapping("add")
	public String add(Resource user) {
		System.out.println(user);
		return "redirect:/center";
	}

	@RequestMapping("addUser")
	public String addUser() {

		User u = new User();
		u.setId(1);
		u.setName("测试aa");
		u.setAge(250);
		u.setMark("aaaaa");;
		u.setBirth(new Date());

		userService.update(u);
		
		userService.find(u);

		return "ok";
	}
	
	@RequestMapping("selectUser")
	public Object selectUser() {
		
		User u = new User();
		u.setId(1);
		u.setName("测试aa");
		u.setAge(250);
		u.setMark("aaaaa");;
		u.setBirth(new Date());
		
		List<User> list = userService.find(null);
		
		return list;
	}

}
