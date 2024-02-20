package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.JwtAuthenticationEntryPoint;
import com.example.demo.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint point;
	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		 http.csrf(csrf -> csrf.disable()).cors(cors->cors.disable()).authorizeHttpRequests(auth->
		 //auth.requestMatchers("/home/**").hasRole("Admin").requestMatchers("/auth/login").permitAll().anyRequest().authenticated();
		 auth.requestMatchers("/home/**").authenticated().requestMatchers("/auth/login","/swagger-ui/**","/v3/api-docs/**"
		 		+ "").permitAll().anyRequest().authenticated()).exceptionHandling(ex->ex.
		 authenticationEntryPoint(point))
		 .sessionManagement(session->session.sessionCreationPolicy(
		 SessionCreationPolicy.STATELESS));
		
		 http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		 
		 return http.build();
		}

}
