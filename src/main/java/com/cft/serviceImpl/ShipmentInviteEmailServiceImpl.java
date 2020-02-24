package com.cft.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cft.model.AuditLogs;
import com.cft.model.ShipmentInviteEmail;
import com.cft.repo.AuditLogsRepo;
import com.cft.repo.ShipmentInviteRepo;
import com.cft.service.ShipmentInviteEmailService;
import com.cft.util.EmailTemplate;
import com.cft.util.MailSenderByThread;
import com.cft.util.TimeConverter;

@Service
public class ShipmentInviteEmailServiceImpl  implements ShipmentInviteEmailService{

	@Autowired
	private  ShipmentInviteRepo seRepo;
	@Autowired
	private AuditLogsRepo auditLogsRepo;

	@Override
	public List<ShipmentInviteEmail> getRecordByEmail(ShipmentInviteEmail user) {
		List<ShipmentInviteEmail> shipmentInvite = new ArrayList<ShipmentInviteEmail>();
	try {
		shipmentInvite=seRepo.findByEmail(user.getEmail());
		if(!shipmentInvite.isEmpty()) {
			String password=TimeConverter.getAlphaNumericString(10);
		    String	data = 	EmailTemplate.getMailBodyTemplate(user.getEmail(),password);
			
		    AuditLogs auditLogs = new AuditLogs();
		    auditLogs.setEmail(user.getEmail());
		    auditLogs.setPassword(password);
		    auditLogs.setLoggedIn(new Date());
		    auditLogs.setName("");
		    try {
		        auditLogsRepo.save(auditLogs);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		    
		    MailSenderByThread mailSenderByThread = new MailSenderByThread();
			mailSenderByThread.toMailId =user.getEmail();
			mailSenderByThread.msg =data;
			mailSenderByThread.subject="Connecting Companies Together - Login  OTP" ;
			mailSenderByThread.start();
		}
	} catch (Exception e) {
	
		e.printStackTrace();
		shipmentInvite=null;
	}
		return shipmentInvite;
	}
	
	
	/*@Override
	public CustomerDetails userRegisteration(CustomerDetails user) {
		CustomerDetails saveDetails= new CustomerDetails();
		String data="";
		try {
			saveDetails =cdRepo.save(user);
			
			if(saveDetails!=null) {
				MailSenderByThread mailSenderByThread = new MailSenderByThread();
				mailSenderByThread.toMailId =user.getEmail();
				mailSenderByThread.msg =data;
				mailSenderByThread.subject="Registered successfully";
				mailSenderByThread.start();
			}
		} catch (Exception e) {
		e.printStackTrace();
		saveDetails=null;
		}
		return saveDetails;
	}
*/

	

}
