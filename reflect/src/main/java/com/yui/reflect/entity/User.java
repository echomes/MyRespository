package com.yui.reflect.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * 
 * @author Echo
 *
 */
@SuppressWarnings("all")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4190417844068371067L;

	private Integer id;

	private String name;

	private Integer age;

	private Date birth;

	public User() {
		super();
		System.out.println("无参数的构造函数。。");
	}

	public User(String name, Integer age, Date birth) {
		super();
		this.name = name;
		this.age = age;
		this.birth = birth;
		System.out.println("有参数的构造函数。。");
	}

	protected User(Integer id) {
		super();
		this.id = id;
		System.out.println("受保护的构造函数。。");
	}

	private User(String name) {
		super();
		this.name = name;
		System.out.println("私有的构造函数。。");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String show() {
		return "用户信息：" + this.name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}

}
