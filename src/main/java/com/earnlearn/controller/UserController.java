package com.earnlearn.controller;

import java.util.List;

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
import org.springframework.web.server.ResponseStatusException;

import com.earnlearn.entity.User;
import com.earnlearn.serviceImpl.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceInterface userServiceInterface;

	@PostMapping("/insertUser")
	public User saveUser(@RequestBody User user) {
		User user1 = userServiceInterface.saveUser(user);
		return user1;
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {

		User exitUser = userServiceInterface.getById(user.getUid());
		user.setModifiedOn(exitUser.getModifiedOn());
		User user1 = userServiceInterface.updateUser(user);
		return user1;
	}

	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestBody User user) {
		// TODO Auto-generated method stub
		userServiceInterface.deleteUser(user);

	}

	@GetMapping("/getAllUser")
	public List<User> getUserList() {
		return userServiceInterface.getUserList();
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		// TODO Auto-generated method stub
		User user = userServiceInterface.getById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable int id) {
		// TODO Auto-generated method stub
		userServiceInterface.deleteById(id);
	}
}
