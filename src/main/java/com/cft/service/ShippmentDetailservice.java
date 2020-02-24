package com.cft.service;

import java.util.List;

import javax.validation.Valid;

import com.cft.model.AuditLogs;
import com.cft.model.ShipmentInviteEmail;
import com.cft.model.ShippmentDetails;

public interface ShippmentDetailservice {

	ShippmentDetails getDetailsByShippmentId(ShippmentDetails user);

	List<ShippmentDetails> getShipmentRecordByEmail(@Valid ShipmentInviteEmail user);

	List<ShippmentDetails> getShipmentRecordByEmail(@Valid AuditLogs user, String timeZone);

	int getShipmentRecordByEmail(AuditLogs user);

	
}
