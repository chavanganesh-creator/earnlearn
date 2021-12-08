package com.earnlearn.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.earnlearn.dto.TaskDTO;
import com.earnlearn.entity.Task;

@Component
public class TaskConverter {

	public TaskDTO entityToDto(Task task) {
		UserConverter userConverter = new UserConverter();
		
		TaskDTO dto = new TaskDTO();
		dto.setTaskId(task.getTid());
		dto.setName(task.getName());
		dto.setStartDate(task.getStartDate());
		dto.setEndDate(task.getEndDate());
		dto.setComment(task.getComment());
		dto.setDescription(task.getDescription());
		dto.setQuantity(task.getQuantity());
		dto.setStatus(task.getStatus());
		dto.setCreatedOn(task.getCreatedOn());
		dto.setModifiedOn(task.getModifiedOn());
		dto.setUsers(userConverter.entityToDto(task.getUsers()));
		return dto;
	}

	public List<TaskDTO> entityToDto(List<Task> task) {
		return task.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}
	
	public Task dtoToEntity(TaskDTO dto) {
		UserConverter userConverter = new UserConverter();
		Task entity = new Task();
		entity.setTid(dto.getTaskId());
		entity.setName(dto.getName());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		entity.setComment(dto.getComment());
		entity.setDescription(dto.getDescription());
		entity.setQuantity(dto.getQuantity());
		entity.setStatus(dto.getStatus());
		entity.setCreatedOn(dto.getCreatedOn());
		entity.setModifiedOn(dto.getModifiedOn());
		entity.setUsers(userConverter.dtoToEntity(dto.getUsers()));
		return entity;
	}

	public List<Task> dtoToEntity(List<TaskDTO> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
