package com.earnlearn.model;

import java.util.Date;

public class CollegeDTO {

	private int collegeId;
	private String name;
	private Date createdOn;
	private Date modifiedOn;
	
	
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
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
	
	public CollegeDTO(int collegeId, String name, Date createdOn, Date modifiedOn) {
		super();
		this.collegeId = collegeId;
		this.name = name;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	public CollegeDTO() {
		super();
	}
	@Override
	public String toString() {
		return "CollegeDTO [collegeId=" + collegeId + ", name=" + name + ", createdOn=" + createdOn + ", modifiedOn="
				+ modifiedOn + "]";
	}
	
	
}
