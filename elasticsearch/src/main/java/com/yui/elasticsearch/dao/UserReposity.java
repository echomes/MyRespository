package com.yui.elasticsearch.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
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

	 @Query("{\"query\":{\"bool\":{\"must\":[{\"term\":{\"name\":\"test\"}}]}}}")
     Page<User> findByName(String name,Pageable page);
}
