package com.yui.mybatis.modules.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yui.mybatis.common.persistence.entity.DataGrid;
import com.yui.mybatis.common.persistence.web.BaseController;
import com.yui.mybatis.modules.test.entity.User;
import com.yui.mybatis.modules.test.service.UserService;

/**
 * 测试类
 * @author Echo
 *
 */
@Controller
@RequestMapping("test")
public class TestController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("getData")
	@ResponseBody
	public DataGrid getData(HttpServletRequest request,HttpServletResponse response,User user) {
		DataGrid dg = new DataGrid();
		
		this.newPage(request, response);
		user.setName("9");
		PageInfo<User> p = this.userService.findList(user);
		
		dg.setRows(p.getList());
		dg.setTotal(p.getTotal());
		return dg;
	}

}
