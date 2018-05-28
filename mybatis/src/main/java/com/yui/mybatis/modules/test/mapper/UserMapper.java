package com.yui.mybatis.modules.test.mapper;

import java.util.List;

import com.yui.mybatis.common.persistence.annotation.MyBatisDao;
import com.yui.mybatis.common.persistence.dao.CrudDao;
import com.yui.mybatis.modules.test.entity.User;

/**
 * 用户接口
 * @author Echo
 *
 */
@MyBatisDao
public interface UserMapper extends CrudDao<User>{
	
	/**
	 * 批量添加
	 * @param userList
	 */
	void insertList(List<User> userList);


	/**
	 * IN查询
	 * @param ids
	 * @return
	 */
	List<User> queryIn(List<String> ids);
	
}
