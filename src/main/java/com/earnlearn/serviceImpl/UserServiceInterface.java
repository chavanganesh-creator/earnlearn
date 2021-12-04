package com.earnlearn.serviceImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.earnlearn.entity.User;

public interface UserServiceInterface {

	public User saveUser(User user);

	public User updateUser(User user);

	public void deleteUser(User user);

	public List<User> getUserList();
	
	public User getById(int id);
	
	public void deleteById(int id);

}
