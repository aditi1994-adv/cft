package com.cft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class Users  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6851908637806391945L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "username", length = 50)
	private String username;
	
	@NotNull
	@Column(name = "password", length = 50)
	private String password;
	
	@NotNull
	@Column(name = "firstname", length = 50)
	private String firstname;

	@NotNull
	@Column(name = "lastname", length = 50)
	private String lastname;

	
	@NotNull
	@Column(name = "email", length = 100,unique=true)
	private String email;

	@NotNull
	@Column(name = "status",columnDefinition = "integer default '1'")
	private int status;
	
	
	
	@NotNull
	@Column(name = "company_id",columnDefinition = "integer default 0")
	private int companyId;
	
	
	

	@NotNull
	@Column(name = "updation_date",length=100)
	private String updationDate;
	
	
	@NotNull
	@Column(name = "buisness_sector",columnDefinition = "integer default 0")
	private int buisness_sector;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getUpdationDate() {
		return updationDate;
	}


	public void setUpdationDate(String updationDate) {
		this.updationDate = updationDate;
	}


	public int getBuisness_sector() {
		return buisness_sector;
	}


	public void setBuisness_sector(int buisness_sector) {
		this.buisness_sector = buisness_sector;
	}
	
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	
	
	
}
