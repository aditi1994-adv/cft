package com.cft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shipment_details")
public class ShippmentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@NotNull
	@Column(name = "bill_no", length = 200)
	private String billNo;

	@NotNull
	@Column(name = "shipment_id", length = 100)
	private String shipmentId;

	@NotNull
	@Column(name = "reciever_id", length = 20)
	private Long receiverId;

	@NotNull
	@Column(name = "shipment_status",columnDefinition = "integer default 0")
	private int shipmentStatus;
	
	@NotNull
	@Column(name = "shipment_mode",columnDefinition = "TINYINT", length = 4)
	private int shipmentMode;

	@NotNull
	@Column(name = "sender_id",length=4)
	private Long senderId;
	
	
	@NotNull
	@Column(name = "sender_email", length = 100)
	private String senderEmail;
	
	
	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	@Transient
	private String email;
	
	@Transient
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@NotNull
	@Column(name = "company_id",length=20)
	private Long companyId;

	@NotNull
	@Column(name = "created_on",columnDefinition = "varchar(100) default '0000-00-00 00:00:00'")
	private String createdOn;

	@NotNull
	@Column(name = "updated_on",columnDefinition = "varchar(100) default '0000-00-00 00:00:00'")
	private String updatedOn;

	@NotNull
	@Lob
	@Column(name = "shipment_details")
	private String shipmentDetails;

	@NotNull
	@Column(name = "reminder_time",length=200)
	private String reminderTime;

	@NotNull
	@Column(name = "expected_delivery_time",length=100)
	private String expectedDeliveryTime;

	@NotNull
	@Column(name = "Isdelivered",columnDefinition = "integer default 0")
	private int isdelivered;
	
	@NotNull
	@Column(name = "reciever_country",length=100)
	private String recieverCountry;

	@NotNull
	@Column(name = "reciever_city",length=100)
	private String recieverCity;

	@Lob 
	@NotNull
	@Column(name = "reciever_address")
	private String recieverAddress;
	
	@NotNull
	@Column(name = "reciever_email",length=100)
	private String recieverEmail;

	
	@Transient
	private String shipmentStatusValue;
	
	@Transient
	private int msgCount;

	public int getMsgCount() {
		return msgCount;
	}

	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		public String getShipmentStatusValue() {
		return shipmentStatusValue;
	}

	public void setShipmentStatusValue(String shipmentStatusValue) {
		this.shipmentStatusValue = shipmentStatusValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public int getShipmentMode() {
		return shipmentMode;
	}

	public void setShipmentMode(int shipmentMode) {
		this.shipmentMode = shipmentMode;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCreatedOn() {
		return createdOn;
	}




	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getShipmentDetails() {
		return shipmentDetails;
	}

	public void setShipmentDetails(String shipmentDetails) {
		this.shipmentDetails = shipmentDetails;
	}

	public String getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(String reminderTime) {
		this.reminderTime = reminderTime;
	}

	public String getExpectedDeliveryTime() {
		return expectedDeliveryTime;
	}

	public void setExpectedDeliveryTime(String expectedDeliveryTime) {
		this.expectedDeliveryTime = expectedDeliveryTime;
	}

	public int getIsdelivered() {
		return isdelivered;
	}

	public void setIsdelivered(int isdelivered) {
		this.isdelivered = isdelivered;
	}

	public String getRecieverCountry() {
		return recieverCountry;
	}

	public void setRecieverCountry(String recieverCountry) {
		this.recieverCountry = recieverCountry;
	}

	public String getRecieverCity() {
		return recieverCity;
	}

	public void setRecieverCity(String recieverCity) {
		this.recieverCity = recieverCity;
	}

	public String getRecieverAddress() {
		return recieverAddress;
	}

	public void setRecieverAddress(String recieverAddress) {
		this.recieverAddress = recieverAddress;
	}


	public int getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(int shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	
	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public String getRecieverEmail() {
		return recieverEmail;
	}

	public void setRecieverEmail(String recieverEmail) {
		this.recieverEmail = recieverEmail;
	}

	
	
	

}
