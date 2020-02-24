package com.cft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="agent_to_customer")
public class ChatWithAgent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chatId")
	private Long chatId;
	
	@Column(name = "createdOn",length=255)
	private  String createdOn;
	@Column(name = "from_email",length=255)
	private String fromEmail;
	
	@Column(name = "to_email",length=255)
	private String toEmail;
	
	@Column(name = "shipment_id",length=200)
	private  String shipmentId;
	
	@Column(name = "message",length=255)
	private  String message;
	
	private int status;
	
	private Long token;
	
	@Column(name = "read_status",length=11)
	private int readStatus =0;
	
	@Column(name = "tokenTimeout",length=11)
	private int tokenTimeout=1;

	@Transient
	private String response;

	
	
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public Long getToken() {
		return token;
	}
	public void setToken(Long token) {
		this.token = token;
	}
	public int getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(int readStatus) {
		this.readStatus = readStatus;
	}
	public int getTokenTimeout() {
		return tokenTimeout;
	}
	public void setTokenTimeout(int tokenTimeout) {
		this.tokenTimeout = tokenTimeout;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
