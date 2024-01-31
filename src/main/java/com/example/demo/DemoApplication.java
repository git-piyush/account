package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableAutoConfiguration
/*
 * @EnableAutoConfiguration annotation tells Spring Boot to “guess” how you want
 * to configure Spring, based on the jar dependencies that you have added.
 */
/*Since the spring-boot-starter-web dependency added to classpath leads 
 *to configuring Tomcat and Spring MVC, the auto-configuration assumes that 
 *you are developing a web application and sets up Spring accordingly.*/

//@ComponentScan
/*
 * @ComponentScan is an annotation used in the Spring Framework for
 * auto-detecting and registering Spring-managed components (e.g. beans,
 * controllers, services, repositories, etc.) within a specified package or set
 * of packages. When you use @ComponentScan, Spring will scan the specified
 * package(s) for classes annotated with @Component (or any of its
 * specialisations, such as @Controller, @Service, or @Repository) and
 * automatically create instances of these classes as beans in the Spring
 * container.
 */
//@Configuration
/*
 * Spring @Configuration annotation is part of the spring core framework. Spring
 * Configuration annotation indicates that the class has @Bean definition
 * methods. So Spring container can process the class and generate Spring Beans
 * to be used in the application.
 */
public class DemoApplication {
	
	@Bean
	/*
	 * @Bean is used to explicitly define individual beans in a Spring
	 * application, @Configuration is used to define a class as a source of bean
	 * configurations
	 */
	
	/*
	 * During startup, Spring instantiates objects and adds them to the application
	 * context. Objects in the application context are called “Spring
	 * beans”or“components”.
	 */
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*
	 * IOC : Spring IoC (Inversion of Control) Container is the core of Spring
	 * Framework. It creates the objects, configures and assembles their
	 * dependencies, manages their entire life cycle.
	 * 
	 * In simple outsourcing the creation of bean and registering in application context is known
	 * inversion of control
	 */
	/*
	 * IOC container: It is responsible for instantiating, configuring, and
	 * assembling the Spring beans by reading configuration metadata
	 */
	
	/*
	 * DI: DI is nothing but the process of getting the dependencies from the
	 * dependent class via service class.
	 * 
	 * * setter based
	 * * constructor based
	 * * Variable based
	 */
	/*
	 * The Spring IOC container is responsible for instantiating, configuring, and
	 * assembling the Spring beans. The container gets its instructions on what
	 * objects to instantiate, configure, and assemble by reading configuration
	 * metadata. The configuration metadata is represented in XML, Java annotations,
	 * or Java code. It lets you express the objects that compose your application
	 * and the rich interdependencies between those objects.
	 * 
	 * Instantiating the bean
	 * Wiring the beans together
	 * Configuring the beans
	 * Managing the bean’s entire life-cycle
	 * 
	 */
	/*
	 * One of main diffrence between BeanFactory and ApplicationContext is that BeanFactory only
	 * instantiates bean when we call getBean() method while ApplicationContext
	 * instantiates singleton bean when the container is started, It doesn't wait
	 * for getBean() method to be called. BeanFactory uses a lazy initialization
	 * approach whereas ApplicationContext uses an eager initialization approach.
	 */
	
	//By default, a Spring Bean is initialized as a singleton scope.
	
	/*
	 * Why Spring Boot over Spring? Below are some key points which spring boot
	 * offers but spring doesn’t:
	 * 
	 * Starter POM. 
	 * Version Management. 
	 * Auto Configuration. 
	 * Component Scanning.
	 * Embedded server. 
	 * InMemory DB. 
	 * Actuators Spring Boot simplifies the spring
	 * feature for the user:
	 */
	
	//What are the most common Spring Boot CLI commands?
	//-run, -test, -grap, -jar, -war, -install, -uninstall, --init, -shell, -help.
	
	/* What are the actuator-provided endpoints used for monitoring the Spring boot application?
			 Actuators provide below pre-defined endpoints to monitor our application -

			 Health
			 Info
			 Beans
			 Mappings
			 Configprops
			 Httptrace
			 Heapdump
			 Threaddump
			 Shutdown
	*/
	
	
	
	
	
	
	
	
	
}
