package com.landingpagebackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.landingpagebackend.DTO.UserDTO;
import com.landingpagebackend.DTO.UserLoginDTO;
import com.landingpagebackend.Response.LoginMessage;
import com.landingpagebackend.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser") 
    public String SaveUser(@RequestBody UserDTO userDto){

        String id = userService.addUser(userDto);
        return id;
    }

    @PostMapping("/userLogin")
    public ResponseEntity<?> userLogin(@RequestBody UserLoginDTO userLoginDTO){
        LoginMessage loginMessage = userService.loginUser(userLoginDTO);
        return ResponseEntity.ok(loginMessage);
    }
}

