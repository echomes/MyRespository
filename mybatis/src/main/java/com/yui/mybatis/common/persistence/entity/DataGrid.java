package com.yui.mybatis.common.persistence.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * table Json DataGrid模型
 * 
 * 
 */
@SuppressWarnings("all")
public class DataGrid implements java.io.Serializable {

	private static final long serialVersionUID = 0L;
	private Long total = 0L;
	private List rows = new ArrayList();

	public DataGrid() {
		super();
	}

	public DataGrid(Long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
