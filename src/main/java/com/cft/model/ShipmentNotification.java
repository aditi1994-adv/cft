package com.cft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="shipment_notifications")
public class ShipmentNotification  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",length=11)
	private int shipmentNotificationsId;
	
	@Column(name = "shipment_id",length=200)
	private String shipmentId;
	
	@Column(name = "reciever_id",length=11)
	private int recieverId;
	

	@Column(name = "sender_id",length=11)
	private int senderId;
	
	
	@Column(name = "customer_email",length=200)
	private String customerEmail;
	
	@Column(name = "description",length=200)
	private String description;
	
	@Column(name = "user_id",length=11)
	private int  userId;
	
	@Column(name = "send_by",length=11)
	private int  sendBy;
	
	@Column(name = "notification_type",length=11)
	private int  notificationType=1;
	
	@Column(name = "created_on",length=100)
	private String  createdOn;
	
	@Column(name = "expired_on",length=100)
	private String  expiredOn;
	
	@Column(name = "status",length=11)
	private int  status=0;

	public int getShipmentNotificationsId() {
		return shipmentNotificationsId;
	}

	public void setShipmentNotificationsId(int shipmentNotificationsId) {
		this.shipmentNotificationsId = shipmentNotificationsId;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public int getRecieverId() {
		return recieverId;
	}

	public void setRecieverId(int recieverId) {
		this.recieverId = recieverId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSendBy() {
		return sendBy;
	}

	public void setSendBy(int sendBy) {
		this.sendBy = sendBy;
	}

	public int getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(int notificationType) {
		this.notificationType = notificationType;
	}

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
