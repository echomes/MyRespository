package com.echo.activiti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.echo.activiti.dao.CompRepository;
import com.echo.activiti.dao.PersonRepository;
import com.echo.activiti.entity.Comp;
import com.echo.activiti.entity.Person;
import com.echo.activiti.service.ActivitiService;

@SpringBootApplication
@ComponentScan("com.echo.activiti")
@EnableJpaRepositories("com.echo.activiti.dao")
@EntityScan("com.echo.activiti.entity")
public class ActivitiApplication {
	
	@Autowired
	private CompRepository compRepository;
	
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(ActivitiApplication.class, args);
	}

	// 初始化模拟数据
	@Bean
	public CommandLineRunner init(final ActivitiService myService) {
		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				if (personRepository.findAll().size() == 0) {
					personRepository.save(new Person("wtr"));
					personRepository.save(new Person("wyf"));
					personRepository.save(new Person("admin"));
				}
				if (compRepository.findAll().size() == 0) {
					Comp group = new Comp("great company");
					compRepository.save(group);
					Person admin = personRepository.findByUserName("admin");
					Person wtr = personRepository.findByUserName("wtr");
					admin.setComp(group);
					wtr.setComp(group);
					personRepository.save(admin);
					personRepository.save(wtr);
				}
			}
		};
	}
}
