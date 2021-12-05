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

import com.earnlearn.dto.UserDTO;
import com.earnlearn.entity.User;
import com.earnlearn.serviceImpl.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceInterface userServiceInterface;

	@PostMapping("/insertUser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return userServiceInterface.saveUser(user);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		return userServiceInterface.updateUser(user);
	}

	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestBody User user) {
		// TODO Auto-generated method stub
		userServiceInterface.deleteUser(user);

	}

	@GetMapping("/getAllUser")
	public List<UserDTO> getUserList() {
		return userServiceInterface.getUserList();
	}
	
	@GetMapping("/getUsersByRole/{roleId}")
	public List<UserDTO> getUsersByRole(@PathVariable int roleId) {
		return userServiceInterface.getUsersByRole(roleId);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		// TODO Auto-generated method stub
		UserDTO user = userServiceInterface.getById(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable int id) {
		// TODO Auto-generated method stub
		userServiceInterface.deleteById(id);
	}
}
