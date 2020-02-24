package com.cft.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cft.model.AuditLogs;
import com.cft.repo.AuditLogsRepo;
import com.cft.repo.ChatWithAgentRepo;
import com.cft.service.AuditLogsService;


@Service
public class AuditLogsServiceImpl  implements AuditLogsService {
	
	@Autowired
	private AuditLogsRepo auditLogsRepo;
	
	@Autowired
	private  ChatWithAgentRepo chatWithAgentRepo;

	@Override
	public AuditLogs getUserDetail(AuditLogs user) {
		AuditLogs  userData =new AuditLogs();
	try {
		int  loggedInStatus=0;
		
		userData=auditLogsRepo.findByEmailAndPasswordAndLoggedInStatus(user.getEmail(),user.getPassword(),loggedInStatus);
		if(userData!=null) {
			userData.setLoggedInStatus(1);
			auditLogsRepo.save(userData);
			userData.setTimeZone(user.getTimeZone());
			return userData;
		}
		
	} catch (Exception e) {
	e.printStackTrace();
	userData=null;
	}
		return userData;
	}

	@Override
	public AuditLogs updateLoggedInStatus(AuditLogs audit) {
		AuditLogs auditData = new AuditLogs();
	try {
		int loggedInStatus=2;
		int logout =auditLogsRepo.updateLoggedInStatus(loggedInStatus,audit.getAuditLogs());
		
	} catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	auditData=null;
	}
		return auditData;
	}

}
