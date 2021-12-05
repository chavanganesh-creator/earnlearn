package com.earnlearn.serviceImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.earnlearn.entity.Role;

public interface RoleServiceInterface {
	
	public Role saveRole(Role role);
	
	public Role updateRole(Role role);
	
	public  void deleteRoleById(int id);
	
	public List<Role> getRole(Role role);

	public ResponseEntity<?> assignRole(int role_id, int user_id);
}
