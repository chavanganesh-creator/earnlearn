package com.earnlearn.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.earnlearn.dao.DepartmentDaoInterface;
import com.earnlearn.entity.Department;
import com.earnlearn.serviceImpl.DepartmentServiceInterface;

/**
 * @author:Rutuja Jadhav
 * date-25/11/2021
 * department service 
 * 
 */

@Service
public class DepartmentService implements DepartmentServiceInterface {

	@Autowired
	DepartmentDaoInterface departmentDaoInterface;

	// insert data in database

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		department.setCreatedOn(new Date());
		department.setModifiedOn(new Date());
		Department dept = departmentDaoInterface.save(department);
		return dept;
	}

	// update data

	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		department.setModifiedOn(new Date());
		Department dept = departmentDaoInterface.saveAndFlush(department);
		return dept;
	}

	// delete data

	@Override
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDaoInterface.delete(department);

	}

	// delete by id

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		departmentDaoInterface.deleteById(id);

	}

	@Override
	public List<Department> getDepartmentList() {
		// TODO Auto-generated method stub
		return departmentDaoInterface.findAll();
	}

	@Override
	public Department getById(int id) {
		// TODO Auto-generated method stub

		Department response = null;
		Optional<Department> departmentData = departmentDaoInterface.findById(id);
		if (departmentData.isPresent()) {
			Department ddata = departmentData.get();
			response = ddata;
		} else {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST," User Record Not Found");
		}
		return response;
	}

}
