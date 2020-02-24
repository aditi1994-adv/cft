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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="audit_logs")
public class AuditLogs   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "audit_logs")
	private Long auditLogs;
	@NotNull
	@Column(name = "email",length=100)
	private String email;
	@NotNull
	@Column(name = "password")
	private  String password ;

	@Column(name = "name")
	private  String name ;

	
	@Column(name = "logged_in")
	private  Date loggedIn ;

	
	
	@Column(name = "logged_in_status")
	private  int loggedInStatus=0;
	
	@Transient
	private  String timeZone;


	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getLoggedInStatus() {
		return loggedInStatus;
	}
	public void setLoggedInStatus(int loggedInStatus) {
		this.loggedInStatus = loggedInStatus;
	}
	public Date getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Date loggedIn) {
		this.loggedIn = loggedIn;
	}
	public Long getAuditLogs() {
		return auditLogs;
	}
	public void setAuditLogs(Long auditLogs) {
		this.auditLogs = auditLogs;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
