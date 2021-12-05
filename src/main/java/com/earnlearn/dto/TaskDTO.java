package com.earnlearn.dto;

import java.util.Date;
import java.util.List;

public class TaskDTO {

	private int taskId;
	private String name;
	private Date startDate;
	private Date endDate;
	private String comment;
	private String description;
	private int quantity;
	private int status;
	private Date modifiedOn;
	private Date createdOn;
	private List<UserDTO> users;
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "TaskDTO [taskId=" + taskId + ", name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", comment=" + comment + ", description=" + description + ", quantity="
				+ quantity + ", status=" + status + ", modifiedOn=" + modifiedOn + ", createdOn=" + createdOn
				+ ", users=" + users + "]";
	}
	
	public TaskDTO(int taskId, int userId, String name, Date startDate, Date endDate, String comment,
			String description, int quantity, int status, Date modifiedOn, Date createdOn, List<UserDTO> users) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
		this.description = description;
		this.quantity = quantity;
		this.status = status;
		this.modifiedOn = modifiedOn;
		this.createdOn = createdOn;
		this.users = users;
	}
	public TaskDTO() {
		super();
	}
	
	
}
