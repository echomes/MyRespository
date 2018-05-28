package com.yui.mybatis.modules.test.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yui.mybatis.common.persistence.entity.DataGrid;
import com.yui.mybatis.common.persistence.web.BaseController;
import com.yui.mybatis.common.utils.Page;
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
	public DataGrid getData(HttpServletRequest request,HttpServletResponse response) {
		DataGrid dg = new DataGrid();
		User entity = new User();
		
		entity.setPage(new Page<User>(request, response));
		List<User> list = this.userService.findList(entity);
		
		dg.setRows(list);
		dg.setTotal((long)list.size());
		return dg;
	}

}
