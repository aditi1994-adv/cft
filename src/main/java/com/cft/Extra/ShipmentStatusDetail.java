package com.cft.Extra;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


public class ShipmentStatusDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -82430752577273613L;
	

	private int mode_1;
	

	private String shipment_status;


	private int mode_2;
	

	private String shipment_status_air;

	public int getMode_1() {
		return mode_1;
	}

	public void setMode_1(int mode_1) {
		this.mode_1 = mode_1;
	}

	public String getShipment_status() {
		return shipment_status;
	}

	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}

	public int getMode_2() {
		return mode_2;
	}

	public void setMode_2(int mode_2) {
		this.mode_2 = mode_2;
	}

	public String getShipment_status_air() {
		return shipment_status_air;
	}

	public void setShipment_status_air(String shipment_status_air) {
		this.shipment_status_air = shipment_status_air;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	

}
