package com.cft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shipment_status")
public class ShipmentStatus {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@NotNull
	@Column(name = "status", length = 300)
	private String status;

	@NotNull
	@Column(name = "mode",columnDefinition = "TINYINT", length = 4)
	private String mode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	
	
	
	
	
	
}
