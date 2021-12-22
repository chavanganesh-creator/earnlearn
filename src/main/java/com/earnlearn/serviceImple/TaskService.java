package com.earnlearn.serviceImple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.earnlearn.mapper.TaskConverter;
import com.earnlearn.repository.TaskJPA;
import com.earnlearn.repository.UserJPA;
import com.earnlearn.model.ReportDTO;
import com.earnlearn.model.TaskDTO;
import com.earnlearn.model.UserDTO;
import com.earnlearn.entity.Task;
import com.earnlearn.entity.User;
import com.earnlearn.service.TaskServiceInterface;

@Service
public class TaskService implements TaskServiceInterface {

	@Autowired
	TaskJPA taskJPA;
	
	@Autowired
	UserJPA userJPA;

	@Autowired
	TaskConverter taskConverter;
	
	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub	
		return 	taskJPA.save(task);
	}

	@Override
	public ResponseEntity<?> assignTask(Task task) {
		
		ResponseEntity<?> response = null;
		try {
			Task exitTask = taskJPA.findById(task.getTid()).get();
			
			exitTask.setUsers(task.getUsers());
			exitTask.setStatus(task.getStatus());
			exitTask.setModifiedOn(new Date());
			taskJPA.save(exitTask);
			response = new ResponseEntity<>(0,HttpStatus.OK);
		} catch ( Exception e) {
			// TODO: handle exception
			response = new ResponseEntity<>(1,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@Override
	public ResponseEntity<?> updateTask(TaskDTO task) {
		
		ResponseEntity<?> response = null;
		try {
			List<UserDTO> users = new ArrayList<UserDTO>();
			if(task.getUsers()!=null && !task.getUsers().isEmpty()) {
				for(UserDTO user : task.getUsers()) {
					UserDTO u = new UserDTO();
					u.setUserId(user.getUserId());
					users.add(u);
				}
				task.setUsers(users);
			}
			
			
			taskJPA.saveAndFlush(taskConverter.dtoToEntity(task));
			response = new ResponseEntity<>(0,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			response = new ResponseEntity<>(1,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public void deleteTaskById(int id) {
		// TODO Auto-generated method stub
		taskJPA.deleteById(id);
	}

	@Override
	public Task getById(int id) {
		// TODO Auto-generated method stub
		return taskJPA.findById(id).get();
	}

	@Override
	public List<TaskDTO> getTaskList() {
		// TODO Auto-generated method stub
		List<Task> tasks = taskJPA.findAllByOrderByStartDateAsc();
		return taskConverter.entityToDto(tasks);
	}
	
	
	/*
	 * Get all Tasks of a User
	 * 
	 */
	public List<TaskDTO> getTaskByUserid(int uid){
		User user = userJPA.findById(uid).get();
		List<Task> tasks = taskJPA.findAllByUsersOrderByStartDateAsc(user);
		return taskConverter.entityToDto(tasks);
	}
	
	public ReportDTO getReport(int uid){
		long duration = 0;
		ArrayList<Integer> task_ids = new ArrayList<Integer>();
		User user = userJPA.findById(uid).get();
		List<Task> tasks = taskJPA.findAllByUsersOrderByStartDateAsc(user);
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

		List<TaskDTO> tasks = taskConverter.entityToDto(taskJPA.findAll());
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
