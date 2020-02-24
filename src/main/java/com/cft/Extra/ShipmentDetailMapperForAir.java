package com.cft.Extra;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ShipmentDetailMapperForAir  implements RowMapper{


	@Override
	public ShipmentStatusDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShipmentStatusDetail cdrDetail=new ShipmentStatusDetail();
		
	cdrDetail.setShipment_status_air(rs.getString("shipment_status_air"));
		
	return cdrDetail;
	}

}
