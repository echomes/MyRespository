package com.yui.boot.service;

import org.springframework.stereotype.Service;

import com.yui.boot.common.persistence.service.CrudService;
import com.yui.boot.entity.User;
import com.yui.boot.mapper.UserMapper;

@Service
public class UserService extends CrudService<UserMapper, User>{

}
