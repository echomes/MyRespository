package com.yui.spring.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 用户
 * @author Echo
 *
 */
@Configuration
@ConfigurationProperties(prefix="com.yui")
@PropertySource(value="classpath:resource.properties",encoding="utf-8")
public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5914482970937876214L;
	
	private String name;
	private Integer age;
	private Date birth;
	@JsonInclude(Include.NON_NULL)
	private String desc;
	
	public Resource() {
		super();
		
	}
	public Resource(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Resource [name=" + name + ", age=" + age + ", birth=" + birth + ", desc=" + desc + "]";
	}

}
