package com.yui.boot.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yui.boot.common.persistence.entity.DataEntity;

/**
 * 用户
 * 
 * @author Echo
 *
 */
public class User extends DataEntity<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String sex;
	private Integer age;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birth;

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", birth=" + birth + "]";
	}

	@Override
	public void preInsert() {
		
		
	}

}
