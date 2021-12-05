package com.earnlearn.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.earnlearn.dto.DepartmentDto;
import com.earnlearn.entity.Department;

@Component
public class DepartmentConverter {

	public DepartmentDto entityToDto(Department department) {
		UserConverter userConverter = new UserConverter();
		CollegeConverter clgConverter = new CollegeConverter();
		DepartmentDto dto = new DepartmentDto();
		dto.setDeptId(department.getId());
		dto.setName(department.getName());
		dto.setUser(userConverter.entityToDto(department.getUser()));
		dto.setCollege(clgConverter.entityToDto(department.getCollege()));
		return dto;
	}

	public List<DepartmentDto> entityToDto(List<Department> department) {
		return department.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Department dtoToEntity(DepartmentDto departmentDto) {

		Department entity = new Department();
		entity.setId(departmentDto.getDeptId());
		entity.setName(departmentDto.getName());
		return entity;

	}

	public List<Department> dtoToEntity(List<DepartmentDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
