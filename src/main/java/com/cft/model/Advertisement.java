package com.cft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="advertise_announce_details")
public class Advertisement  implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "created_by")
	private  int createdBy ;
	
	@Lob
	@NotNull
	@Column(name="subject")
	private String subject;

	@Lob
	@NotNull
	private String message;
	
	@Lob
	@Column(name="attachment_path")
	private String attachmentPath;

	@Lob
	@Column(name="description_text")
	private String descriptionText;

	
	
	public String getDescriptionText() {
		return descriptionText;
	}


	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}


	@Column(name="customer_email")
	private String customerEmail="";
	
	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	@Lob
	@NotNull
	@Column(name="uploaded_email_path")
	private String uploadedEmailPath;
	
	@NotNull
	@Column(name="sent_on",length=100)
	private String sentOn;
	
	@NotNull
	@Column(name="status",columnDefinition = "TINYINT", length = 4)
	private int status;
	
	@Column(name="business_sector",length=11,columnDefinition = "integer default 0")
	private int businessSector;
	
	@NotNull
	@Column(name="companyId",length=11)
	private int companyId;
	
	
	@NotNull
	@Column(name="creater_type",length=11)
	private int createrType;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getAttachmentPath() {
		return attachmentPath;
	}


	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}


	public String getUploadedEmailPath() {
		return uploadedEmailPath;
	}


	public void setUploadedEmailPath(String uploadedEmailPath) {
		this.uploadedEmailPath = uploadedEmailPath;
	}


	public String getSentOn() {
		return sentOn;
	}


	public void setSentOn(String sentOn) {
		this.sentOn = sentOn;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getBusinessSector() {
		return businessSector;
	}


	public void setBusinessSector(int businessSector) {
		this.businessSector = businessSector;
	}


	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public int getCreaterType() {
		return createrType;
	}


	public void setCreaterType(int createrType) {
		this.createrType = createrType;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
}

