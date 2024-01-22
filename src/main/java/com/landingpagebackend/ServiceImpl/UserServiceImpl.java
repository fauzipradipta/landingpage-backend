package com.landingpagebackend.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.landingpagebackend.DTO.UserDTO;
import com.landingpagebackend.DTO.UserLoginDTO;
import com.landingpagebackend.Entity.User;
import com.landingpagebackend.Repository.UserRepository;
import com.landingpagebackend.Response.LoginMessage;
import com.landingpagebackend.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public String addUser(UserDTO userDto) {
		
		User user = new User(
				userDto.getUserId(),
				userDto.getUsername(),
				userDto.getEmail(),				
				this.passwordEncoder.encode(userDto.getPassword())
		);

		userRepository.save(user);
		return user.getUsername();
	}

	UserDTO userDTO;
	@Override	
	public LoginMessage loginUser (UserLoginDTO userLoginDto) {
		String msg = ""; 
		
		User user1 = userRepository.findByEmail(userLoginDto.getEmail());
		
		if(user1 != null) {
			String password = userLoginDto.getPassword();
			String passwordEncoded = user1.getPassword();
			boolean isPwdRight = passwordEncoder.matches(passwordEncoded, password);
			
			 if(isPwdRight) {
				 Optional <User> user = userRepository.findByUsername(passwordEncoded);
				 if (user.isPresent()) {
	                    return new LoginMessage("Login Success", true);
	                } else {
	                    return new LoginMessage("Login Failed", false);
	                }
	            } else {
	                return new LoginMessage("password Not Match", false);
	            }
	        }else {
	            return new LoginMessage("Email not exits", false);
	        }
				 
		}
			
	}
    


