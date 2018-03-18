package com.yui.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yui.spring.entity.User;
import com.yui.spring.mapper.UserMapper;
import com.yui.spring.service.UserService;

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

	@Override
	public void update(User user) {

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

}
