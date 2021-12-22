package com.earnlearn.serviceImple;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.earnlearn.repository.DepartmentJPA;
import com.earnlearn.entity.Department;
import com.earnlearn.service.DepartmentServiceInterface;

/**
 * @author:Rutuja Jadhav
 * date-25/11/2021
 * department service 
 * 
 */

@Service
public class DepartmentService implements DepartmentServiceInterface {

	@Autowired
    DepartmentJPA departmentJPA;

	// insert data in database

	@Override
	public ResponseEntity<?> saveDepartment(Department department) {
		// TODO Auto-generated method stub
		ResponseEntity<?> response = null;
		try {
			department.setCreatedOn(new Date());
			department.setModifiedOn(new Date());
			Department dept = departmentJPA.save(department);
			response = new ResponseEntity<>("Success",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			response = new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	// update data

	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		department.setModifiedOn(new Date());
		Department dept = departmentJPA.saveAndFlush(department);
		return dept;
	}

	// delete data

	@Override
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentJPA.delete(department);

	}

	// delete by id

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		departmentJPA.deleteById(id);

	}

	@Override
	public List<Department> getDepartmentList() {
		// TODO Auto-generated method stub
		return departmentJPA.findAll();
	}

	@Override
	public Department getById(int id) {
		// TODO Auto-generated method stub

		Department response = null;
		Optional<Department> departmentData = departmentJPA.findById(id);
		if (departmentData.isPresent()) {
			Department ddata = departmentData.get();
			response = ddata;
		} else {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST," User Record Not Found");
		}
		return response;
	}

}
