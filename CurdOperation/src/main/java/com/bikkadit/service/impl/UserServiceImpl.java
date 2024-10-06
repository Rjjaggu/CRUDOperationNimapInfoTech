package com.bikkadit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.entity.User;
import com.bikkadit.helper.AppConstants;
import com.bikkadit.repository.UserRepository;
import com.bikkadit.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		User saveUser = userRepository.save(user);
		return saveUser;
	}

	@Override
	public User updateUser(User user, Long userId) {
		User user2 = userRepository.findById(userId).
		orElseThrow(()->new RuntimeException("User is Not Found " +userId ));
		
		user2.setUserName(user.getUserName());
		user2.setUserEmail(user.getUserEmail());
		user2.setUserNumber(user.getUserNumber());;
		
		User updatedUser = userRepository.save(user2);
		
		return updatedUser;
	}
	
	

	@Override
	public List<User> getAllUser() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}
	
	

	@Override
	public User getSingleUser(Long userId) {
		
     log.info("Enterging Dao cal to get a Single User with userId :",userId);

	 User user = userRepository.findById(userId).
				orElseThrow(()->new RuntimeException(AppConstants.NOT_FOUND +userId ));
	 log.info("Enterging Dao cal to get a Single User with userId :",userId);
	
	 return user;
	}
	
	

	@Override
	public void deleteUser(Long userId) {
		User user = userRepository.findById(userId).
				orElseThrow(()->new RuntimeException(AppConstants.NOT_FOUND +userId ));

		userRepository.delete(user);
	}

}
