package com.earnlearn.model;

import org.springframework.stereotype.Component;

@Component
public class DepartmentDTO {

	private int deptId;
	private String name;
	private UserDTO user;
	private CollegeDTO college;
	
	
	
	public CollegeDTO getCollege() {
		return college;
	}
	public void setCollege(CollegeDTO college) {
		this.college = college;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "DepartmentDto [deptId=" + deptId + ", name=" + name + ", user=" + user + ", college=" + college + "]";
	}
	
	public DepartmentDTO() {
		super();
	}
	public DepartmentDTO(int deptId, String name, UserDTO user, CollegeDTO college) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.user = user;
		this.college = college;
	}

	
}
