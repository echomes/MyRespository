package com.yuimybatis.test;

import org.junit.Test;

/**
 * 测试类
 * 
 * @author Echo
 *
 */
public class MyTest {

	@Test
	public void test() {
		String a = "我的测试";
		new Thread(() -> System.out.println("测试"+a)).start();
	}
}
