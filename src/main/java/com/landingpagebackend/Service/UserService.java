package com.landingpagebackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.landingpagebackend.Entity.User;
import com.landingpagebackend.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	
	public User addUser(@RequestBody User user) {
		userRepository
	}
	
}
