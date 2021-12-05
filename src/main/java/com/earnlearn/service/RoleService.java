package com.earnlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.earnlearn.entity.Role;
import com.earnlearn.entity.User;
import com.earnlearn.serviceImpl.RoleServiceInterface;
import com.earnlearn.dao.RoleDaoInterface;
import com.earnlearn.dao.UserDaoInterface;

@Service
public class RoleService implements RoleServiceInterface {

	@Autowired
	RoleDaoInterface roleDaoInterface;

	@Autowired
	UserDaoInterface userDaoInterface;
	
	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleDaoInterface.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleDaoInterface.saveAndFlush(role);
	}

	@Override
	public void deleteRoleById(int id) {
		// TODO Auto-generated method stub
		roleDaoInterface.deleteById(id);
	}

	@Override
	public List<Role> getRole(Role role) {
		// TODO Auto-generated method stub
		return roleDaoInterface.findAll();
	}

	@Override
	public ResponseEntity<?> assignRole(int user_id, int role_id) {
		ResponseEntity<?> response = null;
		try {
			User user = userDaoInterface.findById(user_id).get();
			Role role = roleDaoInterface.findById(role_id).get();
			user.setRole(role);
			userDaoInterface.saveAndFlush(user);
			response = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			response = new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
