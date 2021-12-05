package com.earnlearn.dto;

import java.util.ArrayList;

public class ReportDTO {

	private int user_id;
	private ArrayList<Integer> task_id;
	private long duration;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	public ArrayList<Integer> getTask_id() {
		return task_id;
	}
	public void setTask_id(ArrayList<Integer> task_id) {
		this.task_id = task_id;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	
}
