package com.example.demo.serviceImpl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	private List<User> userList  = new ArrayList<User>();

	public UserServiceImpl() {
		
		userList.add(new User(UUID.randomUUID().toString(),"Rohit", "test123"));
		userList.add(new User(UUID.randomUUID().toString(),"Virat Kohali", "virat123"));
		
	}
	
	@Override
	public List<User> getUserList(){
		return this.userList;
	}

	@Override
	public String getLoggedInUser(Principal p) {
		// TODO Auto-generated method stub
		return p.getName();
	}
	
	
	
}
