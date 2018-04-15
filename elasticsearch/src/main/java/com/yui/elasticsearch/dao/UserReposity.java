package com.yui.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.yui.elasticsearch.projo.User;

/**
 * DAO
 * 
 * @author Echo
 *
 */
@Repository
public interface UserReposity extends ElasticsearchRepository<User, Long> {

}
