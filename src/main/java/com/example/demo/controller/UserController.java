package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/getUser")
	public List<User> getUserList(){
		List<User> users = userService.getUserList();
		
		return users;
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal p) {
		return userService.getLoggedInUser(p);
	}
	
}
