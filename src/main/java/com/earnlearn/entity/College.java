package com.earnlearn.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String name;
	private Date createdOn;
	private Date modifiedOn;

	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Payment>payment;
	
	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Department>department;
	
	

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
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


	public List<Payment> getPayment() {
		return payment;
	}


	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}


	public List<Department> getDepartment() {
		return department;
	}


	public void setDepartment(List<Department> department) {
		this.department = department;
	}


	
	

	public College(int cid, String name, Date createdOn, Date modifiedOn, List<Payment> payment,
			List<Department> department) {
		super();
		this.cid = cid;
		this.name = name;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.payment = payment;
		this.department = department;
	}


	@Override
	public String toString() {
		return "College [cid=" + cid + ", name=" + name + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", payment=" + payment + ", department=" + department + "]";
	}


	
	

	

	
	
	
}
