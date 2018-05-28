package com.yui.mybatis.modules.test.entity;

import java.util.Date;

import com.yui.mybatis.common.persistence.entity.DataEntity;

/**
 * 用户
 * 
 * @author Echo
 *
 */
public class User extends DataEntity<User>{

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
	}

	public User(String name, Integer age, Date birth) {
		super();
		this.name = name;
		this.age = age;
		this.birth = birth;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}

	@Override
	public void preInsert() {
		
		
	}

	@Override
	public void preUpdate() {
		
		
	}

}
