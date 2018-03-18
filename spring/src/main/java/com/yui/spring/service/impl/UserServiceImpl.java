package com.yui.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.yui.spring.entity.User;
import com.yui.spring.mapper.UserMapper;
import com.yui.spring.service.UserService;
import com.yui.spring.utils.Page;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 业务层实现类
 * 
 * @author Echo
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void save(User user) {

		userMapper.insert(user);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void update(User user) {

		//this.userMapper.deleteByPrimaryKey(16);
		
		//int a = 1/0;
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void delete(Integer id) {

		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<User> find(User user) {

		return userMapper.select(user);
	}

	@Override
	public void findPage(Page<User> page) {
		// 开始分页
		PageHelper.startPage(page.getPage(), page.getPageSize());

		Example ex = new Example(User.class);
		Criteria criteria = ex.createCriteria();
		if (!StringUtils.isEmptyOrWhitespace(page.getParam().getName())) {
			criteria.andLike("name", "%" + page.getParam().getName() + "%");
		}
		page.setList(userMapper.selectByExample(ex));
	}

}
