package com.echo.es.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.echo.es.projo.User;

/**
 * DAO
 * @author Echo
 *
 */
@Repository
public interface UserDao extends ElasticsearchRepository<User, Long> {

}
