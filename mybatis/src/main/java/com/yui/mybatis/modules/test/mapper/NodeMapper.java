package com.yui.mybatis.modules.test.mapper;

import com.yui.mybatis.common.persistence.annotation.MyBatisDao;
import com.yui.mybatis.common.persistence.dao.CrudDao;
import com.yui.mybatis.modules.test.entity.Node;

/**
 * 用户接口
 * @author Echo
 *
 */
@MyBatisDao
public interface NodeMapper extends CrudDao<Node>{
	
	
}
