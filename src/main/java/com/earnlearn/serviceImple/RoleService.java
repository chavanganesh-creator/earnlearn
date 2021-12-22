package com.earnlearn.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.earnlearn.entity.Role;
import com.earnlearn.entity.User;
import com.earnlearn.service.RoleServiceInterface;
import com.earnlearn.repository.RoleJPA;
import com.earnlearn.repository.UserJPA;

@Service
public class RoleService implements RoleServiceInterface {

	@Autowired
    RoleJPA roleJPA;

	@Autowired
	UserJPA userJPA;
	
	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleJPA.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleJPA.saveAndFlush(role);
	}

	@Override
	public void deleteRoleById(int id) {
		// TODO Auto-generated method stub
		roleJPA.deleteById(id);
	}

	@Override
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return roleJPA.findAll();
	}

	@Override
	public ResponseEntity<?> assignRole(int user_id, int role_id) {
		ResponseEntity<?> response = null;
		try {
			User user = userJPA.findById(user_id).get();
			Role role = roleJPA.findById(role_id).get();
			user.setRole(role);
			userJPA.saveAndFlush(user);
			response = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			response = new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
