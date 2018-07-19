package com.yui.boot.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.yui.boot.common.persistence.entity.DataGrid;
import com.yui.boot.common.persistence.web.BaseController;
import com.yui.boot.entity.User;
import com.yui.boot.service.UserService;

@Controller
@RequestMapping("test")
@SuppressWarnings("all")
public class TestController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping("hello")
	public ModelAndView hello(ModelAndView mv) {
		mv.setViewName("boot/test/hello");
		mv.addObject("msg", "测试");
		mv.addObject("a", "ddd");

		User user = new User();
		user.setName("哈哈哈");
		user.setBirth(new Date());
		user.setAge(144);
		mv.addObject("user", user);
		System.out.println(user.getBirth());
		return mv;
	}

	@RequestMapping("index")
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("boot/test/index");
		mv.addObject("msg", "测试");
		mv.addObject("a", "ddd");

		User user = new User();
		user.setName("哈哈哈");
		user.setBirth(new Date());
		user.setAge(144);
		mv.addObject("user", user);

		return mv;
	}

	@RequestMapping("console")
	public ModelAndView console(ModelAndView mv) {
		mv.setViewName("boot/test/console");
		mv.addObject("msg", "测试");
		mv.addObject("a", "ddd");

		User user = new User();
		user.setName("哈哈哈");
		user.setBirth(new Date());
		user.setAge(144);
		mv.addObject("user", user);

		return mv;
	}

	@RequestMapping("json")
	@ResponseBody
	public User json(ModelAndView mv) {
		User user = new User();
		user.setName("哈哈哈");
		user.setBirth(new Date());
		user.setAge(144);
		return user;
	}

	@RequestMapping("getList")
	@ResponseBody
	public DataGrid getList(HttpServletRequest request, HttpServletResponse response, User entity) {
		DataGrid dg = new DataGrid();
		try {
			PageInfo page = this.userService.findPage(this.newPage(request, response), entity);
			dg.setData(page.getList());
			dg.setCount(page.getTotal());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return dg;
	}
}
