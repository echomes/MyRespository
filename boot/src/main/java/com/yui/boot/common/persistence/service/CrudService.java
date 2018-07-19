package com.yui.boot.common.persistence.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yui.boot.common.persistence.dao.CrudDao;
import com.yui.boot.common.persistence.entity.DataEntity;

/**
 * Service基类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
@SuppressWarnings("all")
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> {

	
	private static Class clazz;

	public CrudService() {
		// 1获取子类的class(在创建子类对象的时候,会返回父类的构造方法)
		clazz = this.getClass(); // Student
		// 2获取当前类的带有泛型的父类类型
		ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
		// 3返回实际参数类型(泛型可以写多个)
		Type[] types = type.getActualTypeArguments();
		// 4 获取第一个参数(泛型的具体类) Person.class
		clazz = (Class) types[1];
	}

	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;

	/**
	 * 获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	public T get(String id) {
		T entity;
		try {
			entity = (T) clazz.newInstance();
			entity.setId(id);
			return this.dao.get(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取单条数据
	 * 
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}

	/**
	 * 查询列表数据
	 * 
	 * @param entity
	 * @return
	 */
	public PageInfo<T> findList(T entity) {
		List<T> list = dao.findList(entity);
		PageInfo<T> p = new PageInfo<T>(list);
		return p;
	}

	/**
	 * 查询分页数据
	 * 
	 * @param page
	 *            分页对象
	 * @param entity
	 * @return
	 */
	public PageInfo<T> findPage(Page<T> page, T entity) {
		entity.setPageEntity(page);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<T> list = dao.findList(entity);
		PageInfo<T> p = new PageInfo<T>(list);
		return p;
	}

	/**
	 * 保存数据（插入或更新）
	 * 
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {
		/*if (entity.getIsNewRecord()) {
			entity.preInsert();
			dao.insert(entity);
		} else {
			entity.preUpdate();
			dao.update(entity);
		}*/
	}

	/**
	 * 删除数据
	 * 
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}

}
