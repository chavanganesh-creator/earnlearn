package com.earnlearn.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.earnlearn.dao.UserDaoInterface;
import com.earnlearn.entity.User;
import com.earnlearn.serviceImpl.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserDaoInterface userDaoInterface;

	@Override
	public User saveUser(User user) {
		user.setCreatedOn(new Date());
		user.setModifiedOn(new Date());
		User user1 = userDaoInterface.save(user);
		return user1;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		user.setModifiedOn(new Date());
		User user1 = userDaoInterface.saveAndFlush(user);
		return user1;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDaoInterface.delete(user);

	}

	@Override
	public List<User> getUserList() {
		return userDaoInterface.findAll();
	}

	@Override
	public User getById(int id) {
		
		User response = null;
		Optional<User> userData = userDaoInterface.findById(id);
		if (userData.isPresent()) {
			User udata = userData.get();
			response = udata;
			
		} else {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST," User Record Not Found");
		}
		return response;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userDaoInterface.deleteById(id);
	}

}
