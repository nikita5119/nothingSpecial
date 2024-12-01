package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"mvc.controller.ui","mvc.service"})

//repository/data accss layer package name
@EnableJpaRepositories("mvc.dataAccessLayer")
@EntityScan({"mvc.dataAccessLayer"})

public class NewprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewprojectApplication.class, args);
	}

}
