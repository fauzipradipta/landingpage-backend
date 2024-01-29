package com.landingpagebackend.Service;

import com.landingpagebackend.DTO.UserDTO;
import com.landingpagebackend.DTO.UserLoginDTO;
import com.landingpagebackend.Response.LoginMessage;


public interface UserService {

	String addUser(UserDTO userDto);
	LoginMessage loginUser( UserLoginDTO userloginDTO);
	
}
