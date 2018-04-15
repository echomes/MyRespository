package com.echo.es.projo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 实体类
 * 
 * @author Echo
 *
 */
@Document(indexName = "employee", shards = 2, replicas = 1, type = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5660439170738899448L;

	@Id
	private Long id;
	private String name;
	private Integer age;
	private Date birth;

	@JsonInclude(Include.NON_EMPTY)
	private String desc;

	public User() {
		super();
	}

	public User(String name, Integer age, Date birth) {
		super();
		this.name = name;
		this.age = age;
		this.birth = birth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + ", desc=" + desc + "]";
	}
}
