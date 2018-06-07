package com.yui.reflect.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

import com.yui.reflect.entity.User;

/**
 * 测试
 * @author Echo
 *
 */
public class MyTest {

	@Test
	public void test() throws Exception {
		User u = new User();
		
		Class<?> uc = User.class;

		Constructor<?>[] constructors = uc.getConstructors();
		
		for (Constructor<?> c : constructors) {
			System.out.println(c.getParameterCount());
		}
		
		Method[] methods = uc.getMethods();
		for (Method m : methods) {
			if("setName".equals(m.getName())) {
				m.invoke(u, "aaa");
			}
			//System.out.println(m.getName());
		}
		Method m = uc.getMethod("getName");
		Annotation[] annotations = m.getAnnotations();
		System.out.println(annotations.length);
		Object object = m.invoke(u);
		System.out.println(object);
		//System.out.println(u);
		
		Annotation[] as = uc.getAnnotations();
		System.out.println(as.length);
		for (Annotation a : as) {
			System.out.println(a.annotationType().getName());
		}
	}
}
