package com.earnlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.earnlearn.serviceImpl.RoleServiceInterface;
import com.earnlearn.entity.Role;

@RestController
@RequestMapping("roles")
public class RoleController {
	
	@Autowired
	RoleServiceInterface roleServiceInterface;
	
	@PostMapping("/insertRole")
	public Role saveRole(@RequestBody  Role role) {
		// TODO Auto-generated method stub
		return roleServiceInterface.saveRole(role);
	}

	@PutMapping("/updateRole")
	public Role updateRole(@RequestBody  Role role) {
		// TODO Auto-generated method stub
		return roleServiceInterface.updateRole(role);
	}

	@DeleteMapping("/deleteById")
	public void deleteRoleById(@PathVariable("id")  int id) {
		// TODO Auto-generated method stub
		roleServiceInterface.deleteRoleById(id);
	}

	@GetMapping("/getRoleList")
	public List<Role> getRole(@RequestBody  Role role) {
		// TODO Auto-generated method stub
		return roleServiceInterface.getRole(role);
	}

}
