package com.bikkadit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.entity.User;
import com.bikkadit.helper.AppConstants;
import com.bikkadit.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User createUser = userService.createUser(user);
		
		return new ResponseEntity<User>(createUser,HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId){
		
		User updateUser = userService.updateUser(user, userId);
		
		return new ResponseEntity<User>(updateUser,HttpStatus.CREATED);
		
		
	}
	
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		
		 List<User> allUser = userService.getAllUser();
		
		return new ResponseEntity<>(allUser,HttpStatus.OK);
		
		
	}
	
	
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable Long userId){
		
		logger.info("Request Entering for get single user with userId :{}",userId);
		
		User getSingleUser = userService.getSingleUser(userId);
		
		logger.info("Complete Request for get single user with userId :{}",userId);
		
		return new ResponseEntity<User>(getSingleUser,HttpStatus.OK);
		
		
	}
	
	
	
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		
	     userService.deleteUser(userId);
		
		return new ResponseEntity<>(AppConstants.USER_DELETE,HttpStatus.OK);
		
		
	}
	
	
	
	
	
	

}
