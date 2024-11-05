package com.example.landingpage.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.landingpage.dto.AdminLoginDTO;
import com.example.landingpage.dto.AdminSignupDTO;
import com.example.landingpage.entity.Admin;
import com.example.landingpage.repository.AdminRepository;
import com.example.landingpage.service.AdminService;

@CrossOrigin(origins="*", maxAge = 3600)
@Service
@RestController
@RequestMapping("/api/v1")
public class AdminServiceImpl implements AdminService{
    
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value="/admin/register")
	public ResponseEntity<?>RegisterAdminAcount(@RequestBody AdminSignupDTO adminSignupDTO) {
		LocalDate localDate = LocalDateTime.now().toLocalDate(); 
		
		 

	        // add check for email exists in DB
	        if(adminRepository.existsByEmail(adminSignupDTO.getEmail())){
	            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
	        }
	        
	        Admin admin = new Admin();
	        admin.setFirstName(adminSignupDTO.getFirstName());
	        admin.setLastName(adminSignupDTO.getLastName());
	        admin.setEmail(adminSignupDTO.getEmail());
	        admin.setPassword(passwordEncoder.encode(adminSignupDTO.getPassword()));
	        
	        adminRepository.save(admin);
		
		return  new ResponseEntity<>("User registered successfully", HttpStatus.OK);
	}

	@PostMapping(value="/admin/authenticate")
	public ResponseEntity<String> authenticateUser(@RequestBody AdminLoginDTO adminLoginDTO){

		 org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                adminLoginDTO.getEmail(), adminLoginDTO.getPassword()));

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
		
	}

	

	
}
