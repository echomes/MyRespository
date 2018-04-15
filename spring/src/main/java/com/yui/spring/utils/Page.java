package com.yui.spring.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象
 * 
 * @author Echo
 *
 */
public class Page<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8940315338650983736L;

	/**
	 * 页大小
	 */
	private Integer pageSize = 10;

	/**
	 * 当前页
	 */
	private Integer page = 1;

	/**
	 * 查询条件
	 */
	private T param;

	/**
	 * 分页数据
	 */
	private List<T> list = new ArrayList<T>();

	public Page() {
		super();
	}

	public Page(T param) {
		super();
		this.param = param;
	}

	public Page(Integer pageSize, Integer page) {
		super();
		this.pageSize = pageSize;
		this.page = page;
	}

	public Integer getPageSize() {
		if (pageSize == null) {
			pageSize = 10;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		if (page == null) {
			page = 1;
		}
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<T> getList() {
		if (list == null) {
			list = new ArrayList<T>();
		}
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}

	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", page=" + page + ", param=" + param + ", list=" + list + "]";
	}

}
