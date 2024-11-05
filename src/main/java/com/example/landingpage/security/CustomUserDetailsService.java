package com.example.landingpage.security;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.landingpage.entity.Admin;
import com.example.landingpage.repository.AdminRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	AdminRepository adminRepository; 
	 
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Admin admin = adminRepository.findUserByEmail(email)
				.orElseThrow(()->new UsernameNotFoundException("Email Not Found"));
		
		return new org.springframework.security.core.userdetails.User(
                admin.getEmail(), admin.getPassword(), new ArrayList<>());
	}




	
}
