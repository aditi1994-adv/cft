package com.cft.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cft.Extra.ShipmentDetailMapper;
import com.cft.Extra.ShipmentDetailMapperForAir;
import com.cft.Extra.ShipmentStatusDetail;
import com.cft.model.AuditLogs;
import com.cft.model.ShipmentInviteEmail;
import com.cft.model.ShippmentDetails;
import com.cft.repo.ChatWithAgentRepo;
import com.cft.repo.ShippmentDetailsRepository;
import com.cft.service.ShippmentDetailservice;
import com.cft.util.TimeConverter;

@Service
public class ShippmentDetailserviceImpl  implements ShippmentDetailservice{

	@Autowired
	private ShippmentDetailsRepository shippmentDetailRepo;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ChatWithAgentRepo chatWithAgentRepo;

	@SuppressWarnings("unchecked")
	@Override
	public ShippmentDetails getDetailsByShippmentId(ShippmentDetails user) {
		ShippmentDetails shipmentDetails = new ShippmentDetails();
		try {
			if(user.getBillNo().equals("") || user.getBillNo().equals(null) ) {
				shipmentDetails=shippmentDetailRepo.getDetailsByShipmentNumberAndEmail(user.getShipmentId(),user.getEmail());
			}
			else {
				shipmentDetails=shippmentDetailRepo.getDetailsByShipmentNumberAndEmail(user.getShipmentId(), user.getBillNo(), user.getEmail());	
			}
			if(shipmentDetails != null) {
				if(shipmentDetails.getShipmentMode()==2 || shipmentDetails.getShipmentMode()==3) {
					String FETCH_SQL="SELECT  shipment_status FROM shipment_status_details where mode_1="+shipmentDetails.getShipmentStatus();
					List<ShipmentStatusDetail>	ship=jdbcTemplate.query(FETCH_SQL,new ShipmentDetailMapper());
					shipmentDetails.setStatus(ship.get(0).getShipment_status());
				}
				else if(shipmentDetails.getShipmentMode()==1) {
					String FETCH_SQL="SELECT  shipment_status_air FROM shipment_status_details where mode_2="+shipmentDetails.getShipmentStatus();
					List<ShipmentStatusDetail> ship=jdbcTemplate.query(FETCH_SQL,new ShipmentDetailMapperForAir());
					shipmentDetails.setStatus(ship.get(0).getShipment_status_air());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			shipmentDetails=null;
		}
		return shipmentDetails;
	}

	@Override
	public List<ShippmentDetails> getShipmentRecordByEmail(@Valid ShipmentInviteEmail user) {
		List<ShippmentDetails>  shipmentList = new ArrayList<ShippmentDetails>();

		try {
			//shipmentList=shippmentDetailRepo.getRecords(user.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shipmentList;
	}

	@Override
	public List<ShippmentDetails> getShipmentRecordByEmail(@Valid AuditLogs user,String timeZone) {
		List<ShippmentDetails>  shipmentList = new ArrayList<ShippmentDetails>();
	
		try {
			shipmentList=shippmentDetailRepo.getRecords(user.getEmail());

			if(shipmentList.size()!=0) {
			
			for(ShippmentDetails shipmentDetails : shipmentList) {
				int msgCount=0;
				String shipmentStatus = "";

				if(shipmentDetails.getShipmentMode() == 1) {

					shipmentStatus = shippmentDetailRepo.getShipmentStatusOfMode2(shipmentDetails.getShipmentStatus());

					shipmentDetails.setShipmentStatusValue(shipmentStatus);

				}
				else {
					shipmentStatus = shippmentDetailRepo.getShipmentStatusOfMode1(shipmentDetails.getShipmentStatus());

					shipmentDetails.setShipmentStatusValue(shipmentStatus);
				}
				
				String createdOn = TimeConverter.MillisecondToEmailFormat(shipmentDetails.getCreatedOn(), timeZone);
				String updatedOn = TimeConverter.MillisecondToEmailFormat(shipmentDetails.getUpdatedOn(), timeZone);
				
				shipmentDetails.setCreatedOn(createdOn);
				shipmentDetails.setUpdatedOn(updatedOn);
				
				
				msgCount=chatWithAgentRepo.countByShipmentIdAndReadStatusAndStatus(shipmentDetails.getShipmentId(), 0,2);
				shipmentDetails.setMsgCount(msgCount);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shipmentList;
	}

	@Override
	public int getShipmentRecordByEmail(AuditLogs user) {
		int shipmentList=0;
		try {
	 shipmentList=shippmentDetailRepo.getCount(user.getEmail());

		}catch (Exception e) {
			e.printStackTrace();
			shipmentList=0;
		}
		return shipmentList;
	}



}
