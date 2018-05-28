package com.yui.mybatis.modules.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yui.mybatis.common.persistence.serverice.CrudService;
import com.yui.mybatis.modules.test.entity.User;
import com.yui.mybatis.modules.test.mapper.UserMapper;

@Service
@Transactional(readOnly = true)
public class UserService extends CrudService<UserMapper, User> {

}
