package com.example.demo;

import org.apache.naming.factory.BeanFactory;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.controller.AccountController;
import com.example.demo.entity.Account;
import com.example.demo.serviceImpl.AccountServiceImpl;

@SpringBootApplication
public class DemoApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		// ConfigurableApplicationContext context =
		// SpringApplication.run(DemoApplication.class, args);

		ApplicationContext container = SpringApplication.run(DemoApplication.class, args);

			Exam exam = container.getBean(Exam.class);
			System.out.println(exam.hashCode());
			Exam exam1 = container.getBean(Exam.class);
			System.out.println(exam1.hashCode());
	}

}
