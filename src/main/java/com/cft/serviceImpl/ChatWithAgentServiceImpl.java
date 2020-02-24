package com.cft.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cft.model.AuditLogs;
import com.cft.model.Chat;
import com.cft.model.ChatWithAgent;
import com.cft.model.ShipmentNotification;
import com.cft.model.ShippmentDetails;
import com.cft.model.Users;
import com.cft.repo.ChatWithAgentRepo;
import com.cft.repo.NotificationTableRepository;
import com.cft.repo.ShipmentNotificationRepo;
import com.cft.repo.ShippmentDetailsRepository;
import com.cft.repo.UserRepository;
import com.cft.service.ChatWithAgentService;
import com.cft.util.ConstantAction;
import com.cft.util.TimeConverter;

@Service
public class ChatWithAgentServiceImpl  implements ChatWithAgentService{

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private  ChatWithAgentRepo chatWithAgentRepo;

	@Autowired
	private ShippmentDetailsRepository shippmentDetailRepo;

	@Autowired
	private ShipmentNotificationRepo shipmentNotificationRepo;




	@Override
	public ChatWithAgent insertChatUsingShipmentid(@Valid ChatWithAgent user) {
		ChatWithAgent chatWithAgent =new ChatWithAgent();
		Users userData = new Users();
		try {


			ShippmentDetails details= new ShippmentDetails();

			details = shippmentDetailRepo.findByShipmentId(user.getShipmentId());

			if(details!=null) {
				userData =	userRepo.getDataById(details.getSenderId());
			}
			user.setCreatedOn(String.valueOf(System.currentTimeMillis()));
			user.setToEmail(userData.getEmail());
			user.setToken(System.currentTimeMillis()/6);
			user.setStatus(1);
			user.setTokenTimeout(1);
			user.setReadStatus(0);
			user.setMessage(TimeConverter.getMysqlRealScapeStringDec(user.getMessage()).trim());
			chatWithAgent =	chatWithAgentRepo.save(user);

		} catch (Exception e) {
			e.printStackTrace();
			chatWithAgent=null;
		}
		return chatWithAgent;
	}





	@Override
	public List<ChatWithAgent> getListOfChatByToken(@Valid ChatWithAgent user) {

		List<ChatWithAgent> chat =new ArrayList<>();
		try {
			chat=	chatWithAgentRepo.findByShipmentIdOrderByChatIdDesc(user.getShipmentId());
			if(chat.size()!=0) {
				return chat;
			}
		} catch (Exception e) {
			e.printStackTrace();
			chat=null;
		}
		return chat;
	}





	@Override
	public Long getagentMessageCount(@Valid ChatWithAgent user) {
		Long	chat=0L;
		try {

			chat=chatWithAgentRepo.countByShipmentIdAndStatus(user.getShipmentId(),2);

		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			chat=0L;
		}
		return chat;
	}





	@Override
	public List<ChatWithAgent> getAgentNewMessageByToken(@Valid ChatWithAgent user) {
		List<ChatWithAgent> chat =new ArrayList<>();
		try {
			//chat=	chatRepo.findByTokenOrderByChatIdAsc(user.getToken());
			chat=	chatWithAgentRepo.findByShipmentIdAndStatusOrderByChatIdDesc(user.getShipmentId(),2);
			if(chat.size()!=0) {
				return chat;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			chat=null;
		}

		return chat;
	}





	@Override
	public ChatWithAgent insertChatUsingShipmentid(@Valid ChatWithAgent user, AuditLogs audit) {
		ChatWithAgent chatWithAgent =new ChatWithAgent();
		Users userData = new Users();
		ShippmentDetails shipmentData = new ShippmentDetails();
		try {


			ShippmentDetails details= new ShippmentDetails();

			details = shippmentDetailRepo.findByShipmentId(user.getShipmentId());

			if(details!=null) {
				userData =	userRepo.getDataById(details.getSenderId());
			}
			user.setCreatedOn(String.valueOf(System.currentTimeMillis()));
			user.setToEmail(userData.getEmail());
			user.setToken(System.currentTimeMillis()/6);
			user.setStatus(1);
			user.setMessage(TimeConverter.getMysqlRealScapeStringDec(user.getMessage()).trim());
			
			chatWithAgent =	chatWithAgentRepo.save(user);
			if(chatWithAgent!=null) {

				ShipmentNotification shipmentNotification= new ShipmentNotification();
				Long time=System.currentTimeMillis();
				shipmentNotification.setCreatedOn(String.valueOf(time));
				shipmentNotification.setCustomerEmail(audit.getEmail());
				shipmentNotification.setDescription(chatWithAgent.getMessage());
				shipmentNotification.setExpiredOn(TimeConverter.getTimeAfter8Hrs(time));
				shipmentNotification.setNotificationType(3);
				shipmentNotification.setRecieverId(0);
				shipmentNotification.setSendBy(audit.getAuditLogs().intValue());
				shipmentNotification.setSenderId(0);
				shipmentNotification.setShipmentId(chatWithAgent.getShipmentId());
				shipmentNotification.setStatus(0);


				try {
					shipmentData=shippmentDetailRepo.findByShipmentId(chatWithAgent.getShipmentId());

				} catch (Exception e) {
					e.printStackTrace();
				}
				if(shipmentData!=null) {
					shipmentNotification.setUserId(shipmentData.getSenderId().intValue());

				}
				else {
					shipmentNotification.setUserId(0);

				}
				shipmentNotificationRepo.save(shipmentNotification);


			}

		} catch (Exception e) {
			e.printStackTrace();
			chatWithAgent=null;
		}
		return chatWithAgent;
	}





	@Override
	public int updateReadStatus(String shipmentId, HttpSession session) {
		
		int chatWithAgent= 0;
		try {
			AuditLogs userEmail =(AuditLogs) session.getAttribute(ConstantAction.CUSTOMER_SESSION);
			chatWithAgent=chatWithAgentRepo.updateReadStatus(userEmail.getEmail(),shipmentId);
			if(chatWithAgent==1) {
				return 1;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}





	@Override
	public int updateShipmentStatus(String shipmentId) {
		int chatWithAgent= 0;
		try {
			
			chatWithAgent=chatWithAgentRepo.updateShipmentStatus(shipmentId);
			if(chatWithAgent!=0) {
				return 1;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}






}