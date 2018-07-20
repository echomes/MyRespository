package com.yui.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.yui.boot.common.persistence.annoation.MyBatisDao;
import com.yui.boot.config.Meshsite3Filter;

@SpringBootApplication
@ComponentScan("com.yui.boot")
// @EnableScheduling
@EnableAutoConfiguration
@MapperScan(annotationClass = MyBatisDao.class, basePackages = "com.yui.boot")
@SuppressWarnings("all")
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean fitler = new FilterRegistrationBean();
		Meshsite3Filter siteMeshFilter = new Meshsite3Filter();
		fitler.setFilter(siteMeshFilter);
		fitler.setEnabled(true);        
		fitler.addUrlPatterns("/*"); 
		return fitler;
	}
}
