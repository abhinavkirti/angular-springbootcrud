package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages= {"com","myvalidators","com.beans","com.controller"})
@SpringBootApplication
@EnableJpaRepositories("com.repository")
@EntityScan("com.beans")
@EnableAspectJAutoProxy
@EnableAutoConfiguration
public class Main {

	public static void main(String[] args) {
		ApplicationContext con1=SpringApplication.run(Main.class,args);
		

	}

}
