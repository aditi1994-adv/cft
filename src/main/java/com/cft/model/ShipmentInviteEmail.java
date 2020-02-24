package com.cft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipment_invite_emails")
public class ShipmentInviteEmail  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long shipmentInviteId;
	
	
	@Column(name="email",length=200)
	private String email;
	
	@Column(name="shipment_id",length=11)
	private int shipment_id;

	public Long getShipmentInviteId() {
		return shipmentInviteId;
	}

	public void setShipmentInviteId(Long shipmentInviteId) {
		this.shipmentInviteId = shipmentInviteId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getShipment_id() {
		return shipment_id;
	}

	public void setShipment_id(int shipment_id) {
		this.shipment_id = shipment_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
