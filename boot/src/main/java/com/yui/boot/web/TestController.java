package com.yui.boot.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yui.boot.entity.User;

@Controller()
@RequestMapping("test")
public class TestController {

	@RequestMapping("index")
	public ModelAndView  index(ModelAndView mv) {
		mv.setViewName("boot/test/hello");
		mv.addObject("msg", "测试");
		mv.addObject("a", "ddd");
		
		User user = new User();
		user.setName("哈哈哈");
		user.setBirth(new Date());
		user.setAge(144);
		mv.addObject("user", user);
		
		return mv;
	}
}
