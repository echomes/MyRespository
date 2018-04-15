package com.yui.elasticsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
		User u = new User(7l, "测试");
		userREposity.save(u);
	}

}
