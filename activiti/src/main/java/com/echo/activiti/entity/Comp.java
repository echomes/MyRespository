package com.echo.activiti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 管理员
 * 
 * @author Echo
 *
 */
@Entity
public class Comp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String compName;

	@OneToMany(mappedBy = "comp", targetEntity = Person.class)
	private List<Person> userList;

	public Comp() {
		super();
	}

	public Comp(String compName) {
		super();
		this.compName = compName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public List<Person> getUserList() {
		return userList;
	}

	public void setUserList(List<Person> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "Comp [id=" + id + ", compName=" + compName + ", userList=" + userList + "]";
	}

}
