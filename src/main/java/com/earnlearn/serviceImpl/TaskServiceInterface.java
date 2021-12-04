package com.earnlearn.serviceImpl;

import java.util.List;
import com.earnlearn.entity.Task;

public interface TaskServiceInterface {
	
	public Task saveTask(Task task);
	
	public Task updateTask(Task task);
	
	public void deleteTaskById(int id);
	
	public List<Task> getTaskList();
	
	public Task getById(int id);

//	public List<Task> getTaskByUserid(int uid);


}
