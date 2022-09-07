package com.landingpage.landingpagebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.landingpage.landingpagebackend.repository.OrderRepository;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OrderService {

	@Autowired 
	OrderRepository orderRepository; 
	
}
