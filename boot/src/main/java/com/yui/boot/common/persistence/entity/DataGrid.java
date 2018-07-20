package com.yui.boot.common.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * table Json DataGrid模型
 * 
 * 
 */
@SuppressWarnings("all")
public class DataGrid implements Serializable {

	private static final long serialVersionUID = 0L;
	private Long count = 0L;
	private List data = new ArrayList();
	private String code="0";
	private String msg = "success";

	public DataGrid() {
		super();
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
