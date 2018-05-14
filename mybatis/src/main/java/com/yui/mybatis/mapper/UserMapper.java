package com.yui.mybatis.mapper;

import java.util.List;

import com.yui.mybatis.entity.User;

/**
 * 用户接口
 * @author Echo
 *
 */
public interface UserMapper {
	
	/**
	 * 主键查询
	 * @param id
	 * @return
	 */
	User get(Integer id);
	
	/**
	 * 添加
	 * @param user
	 */
	void insert(User user);
	
	/**
	 * 批量添加
	 * @param userList
	 */
	void insertList(List<User> userList);

	/**
	 * 条件查询
	 * @param user
	 * @return
	 */
	List<User> query(User user);
	
	/**
	 * IN查询
	 * @param ids
	 * @return
	 */
	List<User> queryIn(List<String> ids);
	
}
