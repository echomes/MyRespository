package com.yui.mybatis.modules.test.entity;

import java.util.Date;

import com.yui.mybatis.common.persistence.entity.DataEntity;

/**
 * 节点类
 * @author Echo
 *
 */
public class Node extends DataEntity<Node> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4430801089207022995L;
	
	private String name;
	
	private Float x;
	
	private Float y;
	
	private Date time;

	
	private Node() {
		super();
	}

	private Node(String id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", x=" + x + ", y=" + y + ", time=" + time + "]";
	}

}
