package com.bankingSystem.Baking_Backend.UserControllerr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankingSystem.Baking_Backend.Entityy.Login;
import com.bankingSystem.Baking_Backend.Entityy.ResponseMessage;
import com.bankingSystem.Baking_Backend.UserService.LoginService;

@RestController
@RequestMapping("api/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	

	  @Autowired
	    private LoginService userService;

	    @PostMapping
	    public ResponseEntity<Object> login(@RequestBody Login loginRequest) {
	        boolean isValidUser = userService.validateUser(loginRequest.getEmail(), loginRequest.getPassword());
	        if (isValidUser) {
	            return ResponseEntity.ok(new ResponseMessage("Login Successful!"));
	        } else {
	            return ResponseEntity.status(401).body(new ResponseMessage("Invalid email or password."));
	        }
	    }}
