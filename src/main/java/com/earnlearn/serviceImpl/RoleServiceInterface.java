package com.earnlearn.serviceImpl;

import java.util.List;

import com.earnlearn.entity.Role;

public interface RoleServiceInterface {
	
	public Role saveRole(Role role);
	
	public Role updateRole(Role role);
	
	public  void deleteRoleById(int id);
	
	public List<Role> getRole(Role role);

}
