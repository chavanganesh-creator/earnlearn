package com.earnlearn.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.earnlearn.model.ReportDTO;
import com.earnlearn.model.TaskDTO;
import com.earnlearn.entity.Task;

public interface TaskServiceInterface {
	
	public Task saveTask(Task task);
	
	public ResponseEntity<?> updateTask(TaskDTO task);
	
	public ResponseEntity<?> assignTask(Task task);

	public void deleteTaskById(int id);
	
	public List<TaskDTO> getTaskList();
	
	public Task getById(int id);

	public List<TaskDTO> getTaskByUserid(int uid);

	public ReportDTO getReport(int uid);

	public ReportDTO getReports();

}
