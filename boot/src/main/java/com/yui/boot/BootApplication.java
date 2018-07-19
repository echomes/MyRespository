package com.yui.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.yui.boot.common.persistence.annoation.MyBatisDao;

@SpringBootApplication
@ComponentScan("com.yui.boot")
// @EnableScheduling
@EnableAutoConfiguration
@MapperScan(annotationClass=MyBatisDao.class,basePackages="com.yui.boot")
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
