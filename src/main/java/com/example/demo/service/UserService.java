package com.example.demo.service;

import java.util.List;
import java.security.Principal;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface UserService {

	public List<User> getUserList();
	
	public String getLoggedInUser(Principal p);
	
}
