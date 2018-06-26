package com.yui.mybatis.modules.test.entity;

import java.util.Date;

import com.yui.mybatis.common.persistence.entity.DataEntity;

/**
 * 节点类
 * @author Echo
 *
 */
public class Line extends DataEntity<Line> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4430801089207022995L;
	
	private String name;
	
	private String from;
	
	private String to;
	
	private Date time;

	
	private Line() {
		super();
	}

	private Line(String id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Line [name=" + name + ", from=" + from + ", to=" + to + ", time=" + time + "]";
	}

}
