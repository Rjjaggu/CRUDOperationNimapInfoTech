package com.bikkadit.service;

import java.util.List;

import com.bikkadit.entity.User;

public interface UserService {

	
	User createUser(User user);
	
	User updateUser(User user ,Long userId);
	
	List <User> getAllUser();
	
	User getSingleUser(Long userId);
	
	void deleteUser(Long userId);
}
