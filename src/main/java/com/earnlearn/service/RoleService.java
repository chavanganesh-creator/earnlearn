package com.earnlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earnlearn.entity.Role;
import com.earnlearn.serviceImpl.RoleServiceInterface;
import com.earnlearn.dao.RoleDaoInterface;

@Service
public class RoleService implements RoleServiceInterface {

	@Autowired
	RoleDaoInterface roleDaoInterface;

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

}
