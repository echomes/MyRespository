package com.yui.reflect.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
	
	@Test
	public void testReflect() throws Exception{
		Class<?> c = User.class;
		Object cc = c.newInstance();
		Method m = c.getMethod("setName", String.class);
		m.invoke(cc, "dddd");
		
		//System.out.println(cc);
		
		// 1，获取公共的构造函数
		Constructor<?>[] cp = c.getConstructors();
		for (Constructor<?> cpc : cp) {
			System.out.println(cpc.getName());
			cpc.getGenericParameterTypes();
			System.out.println(cpc.getParameterCount());
		}
		
		Constructor<?>[] pc = c.getDeclaredConstructors();
		for (Constructor<?> pcc : pc) {
			System.out.println(pcc.getName());
		}
		
		
		
		Constructor<?> cs = c.getDeclaredConstructor(String.class);
		cs.setAccessible(true);
		Object u = cs.newInstance("哈哈哈");
		
		Field f = c.getDeclaredField("age");
		f.setAccessible(true);
		f.set(u, 142515);
		
		Method m2 = c.getDeclaredMethod("show");
		m2.setAccessible(true);
		System.out.println(m2.invoke(u));;
		
		System.out.println(u);
	}
}
