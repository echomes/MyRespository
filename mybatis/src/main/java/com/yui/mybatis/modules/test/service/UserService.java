package com.yui.mybatis.modules.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.yui.mybatis.common.persistence.serverice.CrudService;
import com.yui.mybatis.modules.test.entity.Line;
import com.yui.mybatis.modules.test.entity.Node;
import com.yui.mybatis.modules.test.entity.User;
import com.yui.mybatis.modules.test.mapper.LineMapper;
import com.yui.mybatis.modules.test.mapper.NodeMapper;
import com.yui.mybatis.modules.test.mapper.UserMapper;

@Service
@Transactional(readOnly = true)
public class UserService extends CrudService<UserMapper, User> {

	@Autowired
	private NodeMapper nodeMapper;
	
	@Autowired
	private LineMapper lineMapper;
	
	@Transactional(readOnly = false)
	public void insertList(List<User> userList) {
		this.dao.insertList(userList);
	}
	
	public Map getQuneeData() {
		Map map = Maps.newHashMap();
		// 查询节点
		List<Node> nodeList = this.nodeMapper.findList(null);
		map.put("nodes", nodeList);
		
		// 查询线
		List<Line> lineList = this.lineMapper.findList(null);
		map.put("edges", lineList);
		return map;
	}
}
