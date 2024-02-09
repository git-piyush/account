package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("prototype")
public class Exam {

	public Exam() {
		System.out.println("Exam started...!!");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Exam is initializing.");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Exam going to be destroyed.");
	}
}
