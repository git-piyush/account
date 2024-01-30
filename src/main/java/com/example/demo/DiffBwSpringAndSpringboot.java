package com.example.demo;

public class DiffBwSpringAndSpringboot {

	/*
	 * The Spring Framework is an open-source framework for creating
	 * enterprise-level Java applications. It provides comprehensive infrastructure
	 * support, allowing developers to focus on building robust applications without
	 * worrying about underlying infrastructure problems like transaction
	 * management, logging, and security.
	 */	
	
	/*
	 * Spring Boot is an extension of the Spring Framework designed to simplify the
	 * initial setup and development of new Spring applications by providing
	 * defaults and eliminating boilerplate configuration.
	 */
	
	/*1. Configuration
	 * Spring: Requires configuration setup using XML, annotation, or Java-based
	 * configurations. Greater flexibility, but with more manual configurations.
	 * 
	 * Spring Boot: Opinionated default setup, reducing the need for specifying
	 * beans. No code generation and no requirement for XML configuration.
	 * 
	 * 2. Bootstrapping a Project
	 *  Spring: Project setup can be time-consuming. Developers need to ensure all
	 *  dependencies are correctly included.
	 *  
	 * 
	 *  Spring Boot: Uses Spring Initializr for rapid project bootstrapping. Automatically 
	 *  manages and configures dependencies using its starter templates.
	 *  
	 * 3. Embedded Server 
	 *  Spring: Doesn't come with an embedded server. You must need to set up an external
	 *  server and deploy your application to that external server.

		Spring Boot: Comes with embedded Tomcat, Jetty, and Undertow servers, allowing
		applications to run independently. 
	 *
	 *
	 *4. Production-Ready Features
		  Spring: Requires additional setup for features like health checks 
		  and metric collection. 

		  Spring Boot: Comes with built-in tools like Spring Boot Actuator to 
		  monitor and manage production applications. 
	 *
	 *
	 *5. Deployment
			Spring: Generates WAR/EAR files typically deployed to external application servers.

			Spring Boot: Typically generates standalone JAR with embedded servers for simplified 
			deployment.
	 */
	
	
	
}
