package com.earnlearn.config;

import java.util.Date;
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
}
