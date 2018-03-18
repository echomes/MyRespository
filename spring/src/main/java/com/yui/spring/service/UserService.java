package com.yui.spring.service;

import java.util.List;

import com.yui.spring.entity.User;

/**
 * 业务层代码
 * 
 * @author Echo
 *
 */
public interface UserService {

	/**
	 * 保存
	 * 
	 * @param user
	 */
	void save(User user);

	/**
	 * 更新
	 * 
	 * @param user
	 */
	void update(User user);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 查询
	 * 
	 * @param user
	 * @return
	 */
	List<User> find(User user);
}
