package com.sportsshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportsshop.dao.UserRepository;
import com.sportsshop.model.User;
import com.sportsshop.service.UserService;

@RestController
public class UserDetailsController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@PostMapping("user/save") // register
	public ResponseEntity<String> save(@RequestBody User user) {
		try {
			userService.save(user);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("user/list")
	public List<User> findAll() {
		List<User> userList = null;
		try {
			userList= userRepository.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@DeleteMapping("user/{id}")
	public void   delete ( deleteById ) {
		deleteById = null;
		userRepository.deleteById(id);
	}

	@PutMapping("user/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setId(id);
		User userObj = userRepository.findById(id).get();
		userObj.setName(user.getName());// update
		// userObj.setEmail(user.getEmail());
		// userObj.setPassword(user.getPassword());
		// userObj.setMobile(user.getMobile());
		userRepository.save(userObj);
	}

	@GetMapping("user/{id}")
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User userObj = user.get();
			return userObj;
		} else {
			return null;

		}
	}

	@PostMapping("user/login")
	public User login(@RequestBody User user) {
//	log.info(" get -{}", id);
		Optional<User> userObj = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (userObj.isPresent()) {
			// User userObj = user.get();
			return userObj.get();
		} else {
			return null;
		}
	}

}
