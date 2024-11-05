package com.example.landingpage.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.landingpage.dto.AdminLoginDTO;
import com.example.landingpage.dto.AdminSignupDTO;
// import org.springframework.stereotype.Service;
import com.example.landingpage.entity.Admin;

public interface AdminService {
	 ResponseEntity<?> RegisterAdminAcount(AdminSignupDTO adminSignupDTO);
	 ResponseEntity<String> authenticateUser( AdminLoginDTO adminLoginDTO);
}
