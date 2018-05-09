package com.echo.activiti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echo.activiti.entity.Comp;

/**
 * Comp DAO
 * @author Echo
 *
 */
public interface CompRepository extends JpaRepository<Comp, Long> {

}
