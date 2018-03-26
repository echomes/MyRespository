package com.echo.es;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.echo.es.dao.UserDao;
import com.echo.es.projo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootesApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void contextLoads() {

	}

	@Test
	public void add() {
		User u = new User();
		u.setAge(22);
		u.setName("测试");
		u.setBirth(new Date());
		u.setDesc("test");
		u.setId(6l);

		userDao.save(u);
	}

}
