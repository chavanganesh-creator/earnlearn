package com.earnlearn.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.earnlearn.model.DepartmentDTO;
import com.earnlearn.entity.Department;

@Component
public class DepartmentConverter {

	public DepartmentDTO entityToDto(Department department) {
		UserConverter userConverter = new UserConverter();
		CollegeConverter clgConverter = new CollegeConverter();
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDeptId(department.getId());
		dto.setName(department.getName());
		dto.setUser(userConverter.entityToDto(department.getUser()));
		dto.setCollege(clgConverter.entityToDto(department.getCollege()));
		return dto;
	}

	public List<DepartmentDTO> entityToDto(List<Department> department) {
		return department.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Department dtoToEntity(DepartmentDTO departmentDto) {

		Department entity = new Department();
		entity.setId(departmentDto.getDeptId());
		entity.setName(departmentDto.getName());
		return entity;

	}

	public List<Department> dtoToEntity(List<DepartmentDTO> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
