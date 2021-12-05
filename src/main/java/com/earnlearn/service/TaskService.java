package com.earnlearn.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earnlearn.config.TaskConverter;
import com.earnlearn.dao.TaskDaoInterface;
import com.earnlearn.dao.UserDaoInterface;
import com.earnlearn.dto.TaskDTO;
import com.earnlearn.entity.Task;
import com.earnlearn.entity.User;
import com.earnlearn.serviceImpl.TaskServiceInterface;

@Service
public class TaskService implements TaskServiceInterface {

	@Autowired
	TaskDaoInterface taskDaoInterface;
	
	@Autowired
	UserDaoInterface userInterface;

	@Autowired
	TaskConverter taskConverter;
	
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
	public List<TaskDTO> getTaskList() {
		// TODO Auto-generated method stub
		List<Task> tasks = taskDaoInterface.findAll();
		return taskConverter.entityToDto(tasks);
	}
	
	
	/*
	 * Get all Tasks of a User
	 * 
	 */
	public List<TaskDTO> getTaskByUserid(int uid){
		User user = userInterface.findById(uid).get();
		List<Task> tasks = taskDaoInterface.findAllByUsers(user);
		return taskConverter.entityToDto(tasks);
	}
	
}
