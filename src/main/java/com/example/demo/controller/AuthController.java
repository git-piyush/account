package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.JwtRequest;
import com.example.demo.DTO.JwtResponse;
import com.example.demo.security.JwtHelper;
import java.util.Date;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtHelper helper;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@Valid @RequestBody JwtRequest request) {
		 this.doAuthenticate(request.getEmail(), request.getPassword());
		 
		 UserDetails userDetails =
		 userDetailsService.loadUserByUsername(request.getEmail()); 
		 String token = this.helper.generateToken(userDetails);
		 Date tokenEipiryDate = this.helper.getExpirationDateFromToken(token);
		 JwtResponse response = JwtResponse.builder().jwtToken(token).userName(userDetails.getUsername()).tokenExpiry(tokenEipiryDate).build(); 
		 return new ResponseEntity<>(response, HttpStatus.OK);
		 
		}

	private void doAuthenticate(String email, String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            this.manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
		
	}
	
}
