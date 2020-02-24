package com.cft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="admin_notifications")
public class AdminNotification  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long adminNotify;
	
	@NotNull
	@Column(name = "customer_email",length=100)
	private String customerEmail="";
	
	@NotNull
	@Lob
	@Column(name = "description")
	private  String description="" ;
	
	@NotNull
	@Column(name = "notification_type",columnDefinition = "integer default 1")
	private  int notificationType ;
	
	
	@NotNull
	@Column(name = "created_on",length=100)
	private String createdOn;
	
	
	@NotNull
	@Column(name = "expired_on",length=100)
	private String expiredOn;
	

	@NotNull
	@Column(name = "status",columnDefinition = "integer default 0")
	private int status=0;


	
	
	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


	public String getExpiredOn() {
		return expiredOn;
	}


	public void setExpiredOn(String expiredOn) {
		this.expiredOn = expiredOn;
	}


	public Long getAdminNotify() {
		return adminNotify;
	}


	public void setAdminNotify(Long adminNotify) {
		this.adminNotify = adminNotify;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getNotificationType() {
		return notificationType;
	}


	public void setNotificationType(int notificationType) {
		this.notificationType = notificationType;
	}


	

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

	

}
