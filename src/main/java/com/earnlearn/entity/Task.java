package com.earnlearn.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "Task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;
	private String name;
	private Date startDate;
	private Date endDate;
	private String comment;
	private String description;
	private int quantity;
	private int status = -1;
	private Date modifiedOn = new Date();
	private Date createdOn;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "task_user",
 			joinColumns = { @JoinColumn(name = "tid")},
 			inverseJoinColumns = { @JoinColumn(name = "uid")}
			)
	private List<User> users;
	
//	@JoinColumn(foreignKey = @ForeignKey(name="uid"), name="uid")

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
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

	public int getStatus() {
		return status;
	}
	@ManyToMany
	@JoinTable(name="task_user")
	public void setStatus(int status) {
		this.status = status;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Task(int tid, String name, Date startDate, Date endDate, String comment, String description, int quantity,
			int status, Date modifiedOn, Date createdOn, List<User> user) {
		super();
		this.tid = tid;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
		this.description = description;
		this.quantity = quantity;
		this.status = status;
		this.modifiedOn = modifiedOn;
		this.createdOn = createdOn;
		this.users = user;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Task [tid=" + tid + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", comment=" + comment + ", description=" + description + ", quantity=" + quantity + ", status="
				+ status + ", modifiedOn=" + modifiedOn + ", createdOn=" + createdOn + "]";
	}

	


	

}
