package com.cft.service;

import java.util.List;

import com.cft.model.ShipmentInviteEmail;

public interface ShipmentInviteEmailService {

	List<ShipmentInviteEmail> getRecordByEmail(ShipmentInviteEmail user);

	
	
}
