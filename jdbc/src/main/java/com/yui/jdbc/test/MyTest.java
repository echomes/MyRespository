package com.yui.jdbc.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.yui.jdbc.entity.User;
import com.yui.jdbc.utils.JdbcUtils;

/**
 * 测试类
 * @author Echo
 *
 */
public class MyTest {

	@Test
	public void test() throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from user u where u.id = 1";
		CallableStatement pc = conn.prepareCall(sql);
		
		pc.executeQuery(sql);
		
		ResultSet rs = pc.getResultSet();
		
		if(rs.next()) {
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println("姓名："+name);
			System.out.println("年龄："+age);
		}
		System.out.println(pc);
	}
	
	@Test
	public void testJdbc() {
		List<Object> list = new ArrayList<>();
		String sql = "select * from user u";
		//list.add("2");
		List<User> find = JdbcUtils.find(sql, list, User.class);
		System.out.println(find);
		JdbcUtils.close();
	}
	
	@Test
	public void testReflect() throws Exception {
		User user = User.class.newInstance();
		Field[] fields = User.class.getDeclaredFields();
		
		Method[] methods = User.class.getDeclaredMethods();
		
		for (Field field : fields) {
			field.setAccessible(true);
			for (Method method : methods) {
				method.setAccessible(true);
				if(method.getName().contains("set")) {
					System.out.println(method.getName());
				}
			}
		}
		
		for (Method m : methods) {
			m.setAccessible(true);
			//System.out.println(m.getName());
			if("setName".equals(m.getName())) {
				m.invoke(user, "李四");
			}
		}
		
		System.out.println(user);
	}
	

	@Test
	public void testStr() {
		String str = "setNameAd";
		str = str.replace("set", "").toLowerCase();
		System.out.println(str);
	}
	
	
	@Test
	public void testR() {
		
		System.out.println(MyTest.class.toGenericString());
	}
}
