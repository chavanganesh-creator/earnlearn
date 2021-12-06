package com.earnlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earnlearn.config.DepartmentConverter;
import com.earnlearn.dto.DepartmentDto;
import com.earnlearn.entity.Department;
import com.earnlearn.serviceImpl.DepartmentServiceInterface;


/**
 * @author:Rutuja Jadhav
 * date-25/11/2021
 * controller class of department
 * 
 */

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

	@Autowired
	DepartmentServiceInterface departmentServiceInterface;
	
	@Autowired
	DepartmentConverter Converter;

	@PostMapping("/insertDepartment")
	public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
		// TODO Auto-generated method stub
		return departmentServiceInterface.saveDepartment(department);
	}
	
	@PutMapping("/updateDepartment")
	public Department updateDepartment(@RequestBody Department department) {
		// TODO Auto-generated method stub
		Department exitDepartment = departmentServiceInterface.getById(department.getId());
		department.setCreatedOn(exitDepartment.getCreatedOn());
		Department dept = departmentServiceInterface.updateDepartment(department);
		return dept;
	}

	@DeleteMapping("/deleteDepartment")
	public void deleteUser(@RequestBody Department department) {
		// TODO Auto-generated method stub
		departmentServiceInterface.deleteDepartment(department);
	}

	@GetMapping("/getAllDepartment")
	public List<DepartmentDto> getDepartmentList() {
		List<Department> departments=departmentServiceInterface.getDepartmentList();
		return Converter.entityToDto(departments);
	}
	
	@GetMapping("/getDepartmentById/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		// TODO Auto-generated method stub
		Department department= departmentServiceInterface.getById(id);
		return new ResponseEntity<>(department,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable  int id) {
		// TODO Auto-generated method stub
		departmentServiceInterface.deleteById(id);
	}
}
