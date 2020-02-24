/*package com.cft.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cft.model.AdminNotification;
import com.cft.model.ChatWithAgent;
import com.cft.model.ShippmentDetails;
import com.cft.model.Users;
import com.cft.repo.ChatWithAgentRepo;
import com.cft.repo.NotificationTableRepository;
import com.cft.repo.ShippmentDetailsRepository;
import com.cft.repo.UserRepository;
import com.cft.service.ChatWithAgentService;
import com.cft.util.ConstantAction;
import com.cft.util.EmailTemplate;
import com.cft.util.MailSenderByThread;
import com.cft.util.Number;

@Service
public class ChatWithAgentServiceImpl2  implements ChatWithAgentService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private  ChatWithAgentRepo chatWithAgentRepo;
	
	@Autowired
	private ShippmentDetailsRepository shippmentDetailsRepo;
	
	@Autowired
	private NotificationTableRepository notificationTableRepository;
	
	@Override
	public ChatWithAgent sendMessage(@Valid ChatWithAgent user) {
		ChatWithAgent  chatsave = new ChatWithAgent();
		String data="";
		//String str=System.currentTimeMillis();
		
		List<ChatWithAgent> emailExist = new ArrayList<>();
		try {
			if(user.getEmail().trim()!="") {
				emailExist=chatWithAgentRepo.findByEmail(user.getEmail());
				if(emailExist.size()==0) {
					if(user.getMessage().trim()!="") {
						user.setStatus(Number.ONE.getValue());
						user.setToken((System.currentTimeMillis()/1000));
						user.setCreatedOn(new Date());
						user.setMessage(user.getMessage().trim());
						user.setResponse(ConstantAction.EMAIL_SEND);
						chatsave=chatWithAgentRepo.save(user);
						if(chatsave!= null) {
							chatsave.setResponse(ConstantAction.EMAIL_SEND);
							
							data ="start chat with the user";
							
						ShippmentDetails shipmentdetails=shippmentDetailsRepo.findByShipmentId(chatsave.getShipmentId());
						if(shipmentdetails != null) {

							  AdminNotification notificationTable= new AdminNotification();
								notificationTable.setMessage("Query raised by "+chatsave.getEmail());
								notificationTable.setReceiverid(shipmentdetails.getEmail());
								notificationTable.setSenderid(chatsave.getEmail());
								//notificationTable.setCreatedOn());
								notificationTable.setCustomerEmail("");
								notificationTable.setDescription("");
								//notificationTable.setExpiredOn(System.currentTimeMillis());
								notificationTable.setNotificationType(1);
								notificationTable.setStatus(1);
						        AdminNotification noti=notificationTableRepository.save(notificationTable);
						        System.out.println(noti);
						}
						
				List<Users> userOld=userRepo.findByCompanyId(shipmentdetails.getReceiverId().intValue());
				for (Users users : userOld) {
					if(shipmentdetails != null) {
				        AdminNotification notificationTableqwerty= new AdminNotification();
				    
				        AdminNotification notific=notificationTableRepository.save(notificationTableqwerty);
				        System.out.println(notific);
				        data=EmailTemplate.getMailBodyTemplate(user.getName(),chatsave.getToken());
						MailSenderByThread mailSenderByThread = new MailSenderByThread();
						mailSenderByThread.toMailId =user.getEmail();
						mailSenderByThread.msg =data;
						mailSenderByThread.subject="Chat With Admin " ;
						mailSenderByThread.start();
					}
				
				}
				data=EmailTemplate.getMailBodyTemplate(user.getName(),chatsave.getToken());
							MailSenderByThread mailSenderByThread = new MailSenderByThread();
							mailSenderByThread.toMailId =user.getEmail();
							mailSenderByThread.msg =data;
							mailSenderByThread.subject="Chat With Admin " ;
							mailSenderByThread.start();
						}
					}else {
						chatsave.setResponse(ConstantAction.PLEASE_ENTER_MESSAGE);
						return chatsave;
					}
				}
				else {
					if(emailExist  !=  null) {
						user.setStatus(Number.ONE.getValue());
						user.setToken(emailExist.get(0).getToken());
						user.setCreatedOn(new Date());
						user.setMessage(user.getMessage().trim());
						chatsave=chatWithAgentRepo.save(user);
						chatsave.setResponse(ConstantAction.EMAIL_SEND);
						data = 	EmailTemplate.getMailBodyTemplate(user.getName(),emailExist.get(0).getToken());
						
						MailSenderByThread mailSenderByThread = new MailSenderByThread();
						mailSenderByThread.toMailId =user.getEmail();
						mailSenderByThread.msg =data;
						mailSenderByThread.subject="Chat With Admin " ;
						mailSenderByThread.start();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("ChatServiceImpl.chattingWithAdmin()");
				e.printStackTrace();
			chatsave=null;
		}
		return chatsave;
	}

	@Override
	public List<ChatWithAgent> loginUsingToken(@Valid ChatWithAgent user, HttpSession session) {
		List<ChatWithAgent> chat = new ArrayList<>();
		ChatWithAgent chatObj = new ChatWithAgent();
		try {
			chat=	chatWithAgentRepo.findByTokenOrderByChatWithAgentIdDesc(user.getToken());
			if(chat.size()!=0) {
				chat.get(0).setResponse("valid token");
				session.setAttribute(ConstantAction.USER_SESSION, chat.get(0));
				return chat;
			}
			else 
			{
				chatObj.setResponse(ConstantAction.INVALID_TOKEN);
				chat.add(chatObj);
				return chat;
			}
		} catch (Exception e) {
		e.printStackTrace();
			chat=null;
		}
		return chat;
	}

	@Override
	public List<ChatWithAgent> getListOfChatByToken(@Valid ChatWithAgent user) {
		List<ChatWithAgent> chat =new ArrayList<>();
		try {
			chat=	chatWithAgentRepo.findByTokenOrderByChatWithAgentIdDesc(user.getToken());
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
	public ChatWithAgent groupChatWithAdmin(@Valid ChatWithAgent user) {
		List<ChatWithAgent> oldChat= new ArrayList<>();
		ChatWithAgent saveChat= new ChatWithAgent();
		ChatWithAgent newChat= new ChatWithAgent();
		try {
			oldChat	=chatWithAgentRepo.findByTokenOrderByChatWithAgentIdDesc(user.getToken());
			if(oldChat !=null) {
				newChat.setMessage(user.getMessage());
				newChat.setToken(oldChat.get(0).getToken());
				newChat.setStatus(Number.ONE.getValue());
				newChat.setCreatedOn(new Date());
				newChat.setEmail(oldChat.get(0).getEmail());
				newChat.setName(oldChat.get(0).getName());
				newChat.setShipmentId(oldChat.get(0).getShipmentId());
				saveChat=	chatWithAgentRepo.save(newChat);
			}else {
				saveChat.setResponse(ConstantAction.INVALID_TOKEN);
				return saveChat;
			}
		} catch (Exception e) {
			e.printStackTrace();
			saveChat=null;
		}
		return saveChat;	}










	

}
*/