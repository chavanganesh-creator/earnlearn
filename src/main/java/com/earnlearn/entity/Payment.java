package com.earnlearn.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int transactionId;
	private Date date;
	private String status;
	private Date modifiedOn;
	private Date createdOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name="cid"),name="cid")
    private College college;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name="uid"),name="uid")
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
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public Payment(int id, int transactionId, Date date, String status, Date modifiedOn, Date createdOn) {
		super();
		this.id = id;
		this.transactionId = transactionId;
		this.date = date;
		this.status = status;
		this.modifiedOn = modifiedOn;
		this.createdOn = createdOn;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", transactionId=" + transactionId + ", date=" + date + ", status=" + status
				+ ", modifiedOn=" + modifiedOn + ", createdOn=" + createdOn + "]";
	}

}
