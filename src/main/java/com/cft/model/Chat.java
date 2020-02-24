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

import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;



@Entity
@Table(name="chat")
public class Chat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7994693385817183079L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chatId")
	private Long chatId;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String message;

	private int status;
	
	@Column(name = "tokenTimeout",columnDefinition = "integer default 1")
	private int tokenTimeout;
	
	
	private  String subject;
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	private  String email;
	private  String toadmin;
	
	
	private int read_status=0;
	
	public int getRead_status() {
		return read_status;
	}

	public void setRead_status(int read_status) {
		this.read_status = read_status;
	}
	private Long token;
	
	@Column(name = "createdOn")
	private  String createdOn;
	
	
	
	
	
	public String getToadmin() {
		return toadmin;
	}

	public void setToadmin(String toadmin) {
		this.toadmin = toadmin;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	@Transient
	private String response;
	
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}


	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTokenTimeout() {
		return tokenTimeout;
	}

	public void setTokenTimeout(int tokenTimeout) {
		this.tokenTimeout = tokenTimeout;
	}


	

}
