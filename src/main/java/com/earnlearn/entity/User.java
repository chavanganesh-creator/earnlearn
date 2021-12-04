package com.earnlearn.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*  @ author Nalanda */
@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private String name;
	private String email;
	private String password;
	private Date createdOn;
	private Date modifiedOn;
	
	@ManyToMany(mappedBy = "users")
	private List<Task> tasks;
	
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public User(int uid, String name, String email, String password, Date createdOn, Date modifiedOn) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + uid + ", name=" + name + ", email=" + email + ", password=" + password + ", createdOn="
				+ createdOn + ", modifiedOn=" + modifiedOn + "]";
	}
	
	
	
	

	

}
