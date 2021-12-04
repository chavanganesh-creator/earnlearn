package com.earnlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earnlearn.entity.Task;
import com.earnlearn.entity.TaskUpdateDTO;
import com.earnlearn.serviceImpl.TaskServiceInterface;
import com.earnlearn.serviceImpl.UserServiceInterface;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskServiceInterface taskServiceInterface;

	@Autowired
	UserServiceInterface userserviceinterface;
	
	@PostMapping("/saveTask")
	public Task saveTask(@RequestBody Task task) {
		System.out.println(task);
		Task saveTask= taskServiceInterface.saveTask(task);
		System.out.println(saveTask);
		return saveTask;
	}

	@PutMapping("/updateTask")
	public Task updateTask(@RequestBody Task task) {
		// TODO Auto-generated method stub
		return taskServiceInterface.updateTask(task);
	}

	@DeleteMapping("/deleteTaskById/{id}")
	public void deleteTaskById(@PathVariable int id) {
		// TODO Auto-generated method stub
		taskServiceInterface.deleteTaskById(id);
	}

	@GetMapping("/getById/{id}")
	public Task getById(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		return taskServiceInterface.getById(id);
	}

	@GetMapping("/getTaskList")
	public List<Task> getTaskList() {
		// TODO Auto-generated method stub
		return taskServiceInterface.getTaskList();
	}
	
	@GetMapping("/getTaskByUid/{uid}")
	public List<Task> getTaskByUserid(@PathVariable int uid){
		return taskServiceInterface.getTaskByUserid(uid);
	}

}
