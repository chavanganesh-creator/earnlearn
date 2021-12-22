package com.earnlearn.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.earnlearn.model.UserDTO;
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

	public User dtoToEntity(UserDTO dto) {

		User entity = new User();
		entity.setUid(dto.getUserId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		return entity;

	}

	public List<User> dtoToEntity(List<UserDTO> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
