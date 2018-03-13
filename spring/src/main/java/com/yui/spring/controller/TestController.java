package com.yui.spring.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yui.spring.entity.Resource;

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

	@RequestMapping("hello")
	public Object hello() {

		System.out.println(user);

		Resource u = new Resource();
		BeanUtils.copyProperties(user, u);

		return u;
	}

}
