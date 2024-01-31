package com.example.demo;

public class SpringBootKeyFeatures {

	/*
	 * Spring Boot starters 
	 * Spring Boot autoconfiguration 
	 * Elegant configuration management 
	 * Spring Boot Actuator 
	 * Easy-to-use embedded servlet container support
	 */
	
	/*
	 * 1. Spring Boot Starters 
	 * Starters are nothing but packet of dependencies that
	 * simplify dependency management. They encapsulate common configurations and
	 * dependencies needed for specific functionalities, such as database
	 * connectivity, security, web services, and more. Starters make it easy to add
	 * required dependencies with minimal effort and reduce version compatibility
	 * issues.
	 * 
	 * For example, the spring-boot-starter-data-jpa starter module includes all the
	 * dependencies required to use Spring Data JPA, along with Hibernate library
	 * dependencies, as Hibernate is the most commonly used JPA implementation.
	 * 
	 * One more example, when we add the spring-boot-starter-web dependency, it will
	 * by default pull all the commonly used libraries while developing Spring MVC
	 * applications, such as spring-webmvc, jackson-json, validation-api, and
	 * tomcat. Not only does the spring-boot-starter-web add all these libraries but
	 * it also configures the commonly registered beans like DispatcherServlet,
	 * ResourceHandlers, MessageSource, etc. with sensible defaults.
	 */
	
	/*
	 * 2. Spring Boot Autoconfiguration Spring Boot provides automatic configuration
	 * for various components based on the classpath dependencies present in the
	 * project. It eliminates the need for manual configuration, reduces boilerplate
	 * code, and simplifies the setup process.
	 * 
	 * For example, if you have the spring-webmvc dependency in your classpath,
	 * Spring Boot assumes you are trying to build a SpringMVC-based web application
	 * and automatically tries to register DispatcherServlet if it is not already
	 * registered.
	 * 
	 * If you have any embedded database drivers in the classpath, such as H2 or
	 * HSQL, and if you haven’t configured a DataSource bean explicitly, then Spring
	 * Boot will automatically register a DataSource bean using in-memory database
	 * settings.
	 */
	
	/*
	 * 3. Elegant Configuration Management 
	 * Spring Boot allows you to externalize
	 * configuration properties, such as database connection details, server port,
	 * and logging settings. It supports various configuration formats like
	 * properties files, YAML files, environment variables, and more. The
	 * externalized configuration makes it easier to configure and manage
	 * application properties in different environments.
	 */
	
	/*
	 * 4. Spring Boot Actuator 
	 * Spring Boot Actuator provides production-ready
	 * features out of the box. It allows developers to monitor and manage the
	 * application using built-in endpoints for health checks, metrics, logging, and
	 * more. Traditional Spring does not provide these features by default.
	 */
	
	/*
	 * 5. Easy-to-Use Embedded Servlet Container Support 
	 * Traditionally, while
	 * building web applications, you need to create a WAR file of your spring
	 * project and then deploy them on external servers like Tomcat, WildFly, etc.
	 * Spring Boot allows you to package your application as a standalone JAR file.
	 * It includes an embedded servlet container (Tomcat, Jetty, or Undertow) by
	 * default, making it easy to deploy and run applications without requiring an
	 * external server.
	 */


}
