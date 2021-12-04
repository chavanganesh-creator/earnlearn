package com.earnlearn.serviceImpl;

/**
 * @author:Rutuja Jadhav
 * date-25/11/2021
 * department service interfaces
 * 
 */

import java.util.List;

import com.earnlearn.entity.Department;

public interface DepartmentServiceInterface {
	
	public Department saveDepartment(Department department);
	
	public Department updateDepartment(Department department);
	
	public void deleteDepartment(Department department);
	
	public List<Department> getDepartmentList();
	
	public Department getById(int id);
	
	public void deleteById(int id);
	

}
