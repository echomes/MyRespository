package com.yui.mybatis.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.yui.mybatis.cfg.MybatisCfgBuilder;
import com.yui.mybatis.modules.test.entity.User;
import com.yui.mybatis.modules.test.mapper.UserMapper;

/**
 * 测试类
 * 
 * @author Echo
 *
 */
public class MyTest {

	@Test
	public void test() {
		SqlSession session = MybatisCfgBuilder.sqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);

		User u = new User();
		u.setName("%测试%");

		List<User> userList = userMapper.findList(u);

		for (User user : userList) {
			System.out.println(user);
		}

		session.close();
	}

	@Test
	public void testAddList() {
		SqlSession session = MybatisCfgBuilder.sqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);

		List<User> userList = Lists.newArrayList();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			userList.add(new User("测试_" + i, i, new Date()));
		}

		userMapper.insertList(userList);

		session.commit();
		session.close();
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000);
	}
	
	@Test
	public void testQueryIn() {
		SqlSession session = MybatisCfgBuilder.sqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);


		List<String> ids = Lists.newArrayList();
		//ids.add("1");ids.add("2");
		
		
		List<User> userList = userMapper.queryIn(ids);

		for (User user : userList) {
			System.out.println(user);
		}

		session.close();
	}
}
