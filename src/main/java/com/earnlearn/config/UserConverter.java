package com.earnlearn.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.earnlearn.dto.UserDTO;
import com.earnlearn.entity.User;


@Component
public class UserConverter {

	public UserDTO entityToDto(User user) {
		UserDTO dto = new UserDTO();
		dto.setUserId(user.getUid());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setRole(user.getRole());
		dto.setPassword(user.getPassword());
		return dto;
	}

	public List<UserDTO> entityToDto(List<User> user) {
		return user.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

//	public Department dtoToEntity(DepartmentDto departmentDto) {
//
//		Department entity = new Department();
//		entity.setId(departmentDto.getDeptId());
//		entity.setName(departmentDto.getName());
//		return entity;
//
//	}
//
//	public List<Department> dtoToEntity(List<DepartmentDto> dto) {
//		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
//	}
}
