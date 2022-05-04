package com.sportsshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsshop.dao.UserRepository;

import com.sportsshop.model.User;
import com.sportsshop.validation.UserValidation;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public void save(User user) throws Exception {
		try {
			UserValidation.validate(user);
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<User> findAll() throws Exception {
		List<User> userList = null;
		try {
			userList = userRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return userList;
	}
	
}
