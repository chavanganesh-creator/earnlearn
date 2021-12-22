package com.earnlearn.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.earnlearn.entity.Role;

public interface RoleServiceInterface {
	
	public Role saveRole(Role role);
	
	public Role updateRole(Role role);
	
	public  void deleteRoleById(int id);
	
	public List<Role> getRole();

	public ResponseEntity<?> assignRole(int role_id, int user_id);
}
