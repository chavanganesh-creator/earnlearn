package com.earnlearn.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.earnlearn.dao.TaskDaoInterface;
import com.earnlearn.dao.UserDaoInterface;
import com.earnlearn.entity.Task;
import com.earnlearn.entity.TaskDTO;
import com.earnlearn.entity.User;
import com.earnlearn.serviceImpl.TaskServiceInterface;

@Service
public class TaskService implements TaskServiceInterface {

	@Autowired
	TaskDaoInterface taskDaoInterface;
	
	@Autowired
	UserDaoInterface userInterface;

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub	
		return 	taskDaoInterface.save(task); 
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		Task exitTask = taskDaoInterface.findById(task.getTid()).get();
		
		exitTask.setUsers(task.getUsers());
		exitTask.setModifiedOn(new Date());
		return taskDaoInterface.save(exitTask);
	}

	@Override
	public void deleteTaskById(int id) {
		// TODO Auto-generated method stub
		taskDaoInterface.deleteById(id);
	}

	@Override
	public Task getById(int id) {
		// TODO Auto-generated method stub
		return taskDaoInterface.findById(id).get();
	}

	@Override
	public List<Task> getTaskList() {
		// TODO Auto-generated method stub
		return taskDaoInterface.findAll();
	}
	
	/*
	 * Get all Tasks of a User
	 * 
	 */
//	public List<Task> getTaskByUserid(int uid){
//		User user = userInterface.findById(uid).get();
//		return taskDaoInterface.findAllByUsers(user);
//	}
//	public List<TaskDTO> getTaskByUser(int id){
//		
//	}
	
	
	/*
	 * Convert Entity To a DTO
	 */
	public TaskDTO convertEntityToDTO(Task task) {
		
		TaskDTO taskDTO = new TaskDTO();
		
		taskDTO.setTaskId(task.getTid());
		taskDTO.setName(task.getName());
		taskDTO.setStartDate(task.getStartDate());
		taskDTO.setEndDate(task.getEndDate());
		taskDTO.setDescription(task.getDescription());
		taskDTO.setComment(task.getComment());
		taskDTO.setStatus(task.getStatus());
		taskDTO.setCreatedOn(task.getCreatedOn());
		taskDTO.setModifiedOn(task.getModifiedOn());
		
		return taskDTO;
	}
}
