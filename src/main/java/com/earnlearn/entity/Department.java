package com.earnlearn.entity;

/*
 * @author:Rutuja Jadhav
 * date-25/11/2021
 * department entity class
 * 
 */

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int did;
	private String name;
	private Date createdOn;
	private Date modifiedOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name="cid"), name="cid")
	private College college;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name="uid"), name="uid")
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public int getId() {
		return did;
	}

	public void setId(int id) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Department(int id, String name, Date createdOn, Date modifiedOn) {
		super();
		this.did = did;
		this.name = name;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [id=" + did + ", name=" + name + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", college=" + college + "]";
	}

	

}
