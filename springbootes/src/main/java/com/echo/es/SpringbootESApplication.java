package com.echo.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.echo.es.dao.UserDao;
import com.echo.es.projo.User;

@SpringBootApplication
public class SpringbootESApplication {
	

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(SpringbootESApplication.class, args);
		
		UserDao userDao = ac.getBean(UserDao.class);
		Iterable<User> iter = userDao.findAll();

		for (User user : iter) {
			System.out.println(user);
		}
	}
}
