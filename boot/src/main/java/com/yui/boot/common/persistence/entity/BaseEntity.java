/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.yui.boot.common.persistence.entity;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.Page;
import com.yui.boot.entity.User;

/**
 * Entity支持类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 实体编号（唯一标识）
	 */
	protected String id;

	/**
	 * 当前用户
	 */
	protected User currentUser;

	/**
	 * 当前实体分页对象
	 */
	protected Page<T> pageEntity;

	/**
	 * 自定义SQL（SQL标识，SQL内容）
	 */
	protected Map<String, String> sqlMap;

	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
	 */
	protected boolean isNewRecord = false;

	private Object obj;// 额外参数

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public BaseEntity() {

	}

	public BaseEntity(String id) {
		this();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	@XmlTransient
	public User getCurrentUser() {
		if (currentUser == null) {
			// currentUser = UserUtils.getUser();
		}
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	@JsonIgnore
	@XmlTransient
	public Page<T> getPageEntity() {
		if (pageEntity == null) {
			pageEntity = new Page<T>();
		}
		return pageEntity;
	}

	public Page<T> setPageEntity(Page<T> pageEntity) {
		this.pageEntity = pageEntity;
		return pageEntity;
	}


	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}

	/**
	 * 插入之前执行方法，子类实现
	 */
	public abstract void preInsert();

	/**
	 * 更新之前执行方法，子类实现
	 */
	public abstract void preUpdate();


	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
	 */
	public void setIsNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		BaseEntity<?> that = (BaseEntity<?>) obj;
		return null == this.getId() ? false : this.getId().equals(that.getId());
	}

	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";

}
