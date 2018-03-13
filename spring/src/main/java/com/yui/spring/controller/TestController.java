package com.yui.spring.controller;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yui.spring.entity.Resource;

/**
 * 测试
 * 
 * @author Echo
 *
 */
@Controller
public class TestController {

	@Autowired
	private Resource user;

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
		int a = 1/0;
		System.out.println(user);
		return "redirect:/center";
	}

}
