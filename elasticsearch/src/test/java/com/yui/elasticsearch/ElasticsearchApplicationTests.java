package com.yui.elasticsearch;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.yui.elasticsearch.dao.UserReposity;
import com.yui.elasticsearch.projo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

	@Autowired
	private UserReposity userREposity;
	
	@Test
	public void contextLoads() {
		try {
			User u = new User(9l, "测试");
			u.setBirth(new Date());
			u.setDesc("aaaaaa");
			u.setAge(145185);
			//userREposity.save(u);
			Iterable<User> all = this.userREposity.findAll();
			for (User user : all) {
				//System.out.println(user);
			}
			Pageable page = PageRequest.of(1, 10);
			Page<User> list = this.userREposity.findByName("test",page );
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
