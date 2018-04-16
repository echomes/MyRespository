package com.echo.activiti.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 用户实体类
 * 
 * @author Echo
 *
 */
@Entity
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 用户名
	 */
	private String userName;

	@ManyToOne(targetEntity = Comp.class)
	private Comp comp;

	public Person() {
		super();
	}

	public Person(String userName) {
		super();
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Comp getComp() {
		return comp;
	}

	public void setComp(Comp comp) {
		this.comp = comp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", comp=" + comp + "]";
	}

}
