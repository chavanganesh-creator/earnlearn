package com.earnlearn.serviceImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.earnlearn.dto.UserDTO;
import com.earnlearn.entity.User;

public interface UserServiceInterface {

	public ResponseEntity<?> saveUser(User user);

	public ResponseEntity<?> updateUser(User user);

	public void deleteUser(User user);

	public List<UserDTO> getUserList();

	public List<UserDTO> getUsersByRole(int roleId);

	public UserDTO getById(int id);
	
	public void deleteById(int id);

}
