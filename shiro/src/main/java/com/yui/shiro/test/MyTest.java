package com.yui.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest {

	private static transient Logger log = LoggerFactory.getLogger(MyTest.class);

	public static void main(String[] args) {
		log.info("测试。。");

		// 1，加载配置文件
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

		// 2，解析配置文件得到SecurityManager
		SecurityManager securityManager = factory.getInstance();

		// 3，设置SecurityManager到静态内存区，单例模式
		SecurityUtils.setSecurityManager(securityManager);

		// 4，得到Subject
		Subject subject = SecurityUtils.getSubject();

		// 5，得到Session
		Session session = subject.getSession();
		session.setAttribute("test", "bb");

		// 匿名用户尝试登陆
		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken("test", "123", false);

			try {
				subject.login(token);
				log.info("[" + subject.getPrincipal() + "]登录成功！");

				// 角色
				if (subject.hasRole("admin")) {
					log.info("用户[" + subject.getPrincipal() + "]拥有角色：admin");
				}

				// 权限
				if (subject.isPermitted("winnebago:drive:eagle5")) {
					log.info("用户[" + subject.getPrincipal() + "]可以drive winnebago 在驾照是eagle5的情况下");
				} else {
					log.info("无权限驾驶");
				}

				// 登出
				subject.logout();
			} catch (UnknownAccountException e1) {
				log.info("用户名不存在！");
			} catch (IncorrectCredentialsException e2) {
				log.info("密码不正确！");
			} catch (LockedAccountException e3) {
				log.info("用户被锁定！");
			} catch (AuthenticationException e4) {
				log.info("无法判断！");
			}
		}
	}

}
