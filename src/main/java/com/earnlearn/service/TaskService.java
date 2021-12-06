package com.earnlearn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.earnlearn.config.TaskConverter;
import com.earnlearn.dao.TaskDaoInterface;
import com.earnlearn.dao.UserDaoInterface;
import com.earnlearn.dto.ReportDTO;
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
	public ResponseEntity<?> assignTask(Task task) {
		
		ResponseEntity<?> response = null;
		try {
			Task exitTask = taskDaoInterface.findById(task.getTid()).get();
			
			exitTask.setUsers(task.getUsers());
			exitTask.setStatus(task.getStatus());
			exitTask.setModifiedOn(new Date());
			taskDaoInterface.save(exitTask);	
			response = new ResponseEntity<>("User and Status in Task updated!",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			response = new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@Override
	public ResponseEntity<?> updateTask(Task task) {
		
		ResponseEntity<?> response = null;
		try {
//			Task exitTask = taskDaoInterface.findById(task.getTid()).get();
//			exitTask.setComment(task.getComment());
//			exitTask.set
//			exitTask.setUsers(task.getUsers());
//			exitTask.setStatus(task.getStatus());
//			exitTask.setModifiedOn(new Date());
			taskDaoInterface.saveAndFlush(task);	
			response = new ResponseEntity<>("Task updated!",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			response = new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
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
		List<Task> tasks = taskDaoInterface.findAllByOrderByStartDateAsc();
		return taskConverter.entityToDto(tasks);
	}
	
	
	/*
	 * Get all Tasks of a User
	 * 
	 */
	public List<TaskDTO> getTaskByUserid(int uid){
		User user = userInterface.findById(uid).get();
		List<Task> tasks = taskDaoInterface.findAllByUsersOrderByStartDateAsc(user);
		return taskConverter.entityToDto(tasks);
	}
	
	public ReportDTO getReport(int uid){
		long duration = 0;
		ArrayList<Integer> task_ids = new ArrayList<Integer>();
		User user = userInterface.findById(uid).get();
		List<Task> tasks = taskDaoInterface.findAllByUsersOrderByStartDateAsc(user);
		for(Task task : tasks) {
			duration = duration + (task.getEndDate().getTime() - task.getStartDate().getTime());
			task_ids.add(task.getTid());
		}
		
		ReportDTO report = new ReportDTO();
		report.setUser_id(user.getUid());
		report.setDuration(TimeUnit.MILLISECONDS.toMinutes(duration));
		report.setTask_id(task_ids);
		return report;
	}

	public ReportDTO getReports(){
		long duration = 0;
		ArrayList<Integer> task_ids = new ArrayList<Integer>();

		List<TaskDTO> tasks = taskConverter.entityToDto(taskDaoInterface.findAll());
		for(TaskDTO task : tasks) {
			duration = duration + (task.getEndDate().getTime() - task.getStartDate().getTime());
			task_ids.add(task.getTaskId());
		}
		
		ReportDTO report = new ReportDTO();
		report.setDuration(TimeUnit.MILLISECONDS.toMinutes(duration));
		report.setTask_id(task_ids);
		return report;
	}
}
