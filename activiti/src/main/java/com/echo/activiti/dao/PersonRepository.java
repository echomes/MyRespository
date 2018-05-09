package com.echo.activiti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echo.activiti.entity.Person;

/**
 * DAO
 * 
 * @author Echo
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByUserName(String userName);
}
