package com.cft.serviceImpl;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cft.model.Admin;
import com.cft.model.AdminNotification;
import com.cft.model.Chat;
import com.cft.repo.AdminRepo;
import com.cft.repo.ChatRepository;
import com.cft.repo.NotificationTableRepository;
import com.cft.service.ChatService;
import com.cft.util.ConstantAction;
import com.cft.util.EmailTemplate;
import com.cft.util.MailSenderByThread;
import com.cft.util.Number;
import com.cft.util.TimeConverter;


@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private  ChatRepository chatRepo;

	@Autowired
	private AdminRepo adminRepo;


	@Autowired
	private NotificationTableRepository notificationTableRepository;



	public Chat saveImages(MultipartFile[] imgFile) {
		// String folder = "/photos/";

		byte[] bytes =new byte[imgFile.length];

		for (int i = 0; i < imgFile.length; i++)
		{
			try {
				long seconds = System.currentTimeMillis();
				//String fileName = seconds+imgFile[i].getOriginalFilename();
				String fileName =imgFile[i].getOriginalFilename();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("D://photos/" +fileName)));
				buffStream.write(bytes);

				buffStream.close();

			} catch (Exception e) {
				//e.printStackTrace();
			}

		}


		return null;
	}

	@Override
	public Chat chattingWithAdmin(@Valid Chat user) {
		Chat  chatsave = new Chat();
		String data="";
		List<Chat> emailExist = new ArrayList<>();
		Admin admin = new Admin();
		Date date = new Date();
		try {
			if(user.getEmail().trim()!="") {
				/*emailExist=chatRepo.findByEmail(user.getEmail());
				if(emailExist.size()==0) {*/
				if(user.getMessage().trim()!="") {
					try {
						admin=adminRepo.getAdminRecord();
						if(admin!=null) {
							user.setToadmin(admin.getEmail());
						}
					} catch (Exception e) {
						e.printStackTrace();
						user.setToadmin("admin email blank");
					}
					user.setRead_status(0);
					user.setTokenTimeout(1);
					user.setStatus(Number.ONE.getValue());
					user.setToken((System.currentTimeMillis()/1000));
					user.setCreatedOn(String.valueOf(System.currentTimeMillis()));
					
					user.setMessage(TimeConverter.getMysqlRealScapeStringDec(user.getMessage().trim()));
					user.setResponse(ConstantAction.EMAIL_SEND);
					chatsave=chatRepo.save(user);
					if(chatsave!= null) {
						chatsave.setResponse(ConstantAction.EMAIL_SEND);
						Long dataRecord =System.currentTimeMillis();
					/*	AdminNotification notificationTable= new AdminNotification();
						notificationTable.setCreatedOn(String.valueOf(dataRecord));
						notificationTable.setExpiredOn(TimeConverter.getTimeAfter8Hrs(dataRecord));
						notificationTable.setCustomerEmail(chatsave.getEmail());
						notificationTable.setDescription(user.getSubject());
						notificationTable.setNotificationType(1);
						notificationTable.setStatus(0);
						try {
							notificationTableRepository.save(notificationTable);

						} catch (Exception e) {
							e.printStackTrace();
						}*/

						data = 	EmailTemplate.getMailBodyTemplate(user.getSubject(),chatsave.getToken());
						MailSenderByThread mailSenderByThread = new MailSenderByThread();
						mailSenderByThread.toMailId =user.getEmail();
						mailSenderByThread.msg =data;
						mailSenderByThread.subject=user.getSubject() ;
						mailSenderByThread.start();
					}

				}else {
					chatsave.setResponse(ConstantAction.PLEASE_ENTER_MESSAGE);
					return chatsave;
				}
				/*}
				else {
					if(emailExist  !=  null) {

						user.setStatus(Number.ONE.getValue());
						user.setToken(emailExist.get(0).getToken());
						user.setCreatedOn(new Date());
						user.setMessage(user.getMessage().trim());
						chatsave=chatRepo.save(user);

						chatsave.setResponse(ConstantAction.EMAIL_SEND);
						data = 	EmailTemplate.getMailBodyTemplate(user.getName(),emailExist.get(0).getToken());

						MailSenderByThread mailSenderByThread = new MailSenderByThread();
						mailSenderByThread.toMailId =user.getEmail();
						mailSenderByThread.msg =data;
						mailSenderByThread.subject="Chat With Admin " ;
						mailSenderByThread.start();
					}

				}*/
			}

			else {
				chatsave.setResponse(ConstantAction.ENTER_EMAIL);
				return chatsave;
			}


		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ChatServiceImpl.chattingWithAdmin()");
		//	e.printStackTrace();
			chatsave=null;
		}
		return chatsave;
	}

	@Override
	public Chat chatUsingToken(@Valid Chat user) {
		// TODO Auto-generated method stub
		List<Chat> oldChat= new ArrayList<>();
		Chat saveChat= new Chat();
		Chat newChat= new Chat();
		Admin admin = new Admin();
		try {

			//			oldChat	=chatRepo.findByTokenOrderByChatIdAsc(user.getToken());
			oldChat	=chatRepo.findByTokenAndTokenTimeoutAndStatusOrderByChatIdDesc(user.getToken(),1,1);
			if(oldChat !=null) {
				newChat.setTokenTimeout(1);
				newChat.setMessage(TimeConverter.getMysqlRealScapeStringDec(user.getMessage().trim()));
				newChat.setToken(oldChat.get(0).getToken());
				newChat.setStatus(Number.ONE.getValue());
				newChat.setCreatedOn(String.valueOf(System.currentTimeMillis()));
				newChat.setEmail(oldChat.get(0).getEmail());
				newChat.setSubject(oldChat.get(0).getSubject());
				newChat.setRead_status(0);
				try {
					admin=adminRepo.getAdminRecord();
					if(admin!=null) {
						newChat.setToadmin(admin.getEmail());
					}

				} catch (Exception e) {
					e.printStackTrace();
					newChat.setToadmin("admin email blank");
				}

				saveChat=chatRepo.save(newChat);


			}else {
				saveChat.setResponse(ConstantAction.INVALID_TOKEN);
				return saveChat;
			}
		} catch (Exception e) {

			e.printStackTrace();
			saveChat=null;
		}
		return saveChat;
	}

	@SuppressWarnings("null")
	@Override
	public List<Chat> getListByToken(@Valid Chat user) {
		List<Chat> chat =new ArrayList<>();
		try {
			//chat=	chatRepo.findByTokenOrderByChatIdAsc(user.getToken());
			chat=	chatRepo.findByTokenOrderByChatIdDesc(user.getToken());


			if(chat.size()!=0) {


				return chat;
			}

		} catch (Exception e) {

			//e.printStackTrace();
			chat=null;
		}

		return chat;
	}

	@SuppressWarnings("null")
	@Override
	public List<Chat> loginUsingToken(@Valid Chat user, HttpSession session) {
		List<Chat> chat = new ArrayList<>();
		Chat chatObj = new Chat();
		try {
			//chat=chatRepo.findByTokenOrderByChatIdAsc(user.getToken());
			chat=	chatRepo.findByTokenAndTokenTimeoutOrderByChatIdDesc(user.getToken(),1);


			if(chat.size()!=0) {
				chat.get(0).setResponse("valid token");
				session.setAttribute(ConstantAction.USER_SESSION, chat.get(0));
				Long dataRecord =System.currentTimeMillis();
				AdminNotification notificationTable= new AdminNotification();
				notificationTable.setCreatedOn(String.valueOf(dataRecord));
				notificationTable.setExpiredOn(TimeConverter.getTimeAfter8Hrs(dataRecord));
				notificationTable.setCustomerEmail(chat.get(0).getEmail());
				notificationTable.setDescription(chat.get(0).getSubject());
				notificationTable.setNotificationType(1);
				notificationTable.setStatus(0);
				try {
					notificationTableRepository.save(notificationTable);

				} catch (Exception e) {
				//	e.printStackTrace();
				}

				return chat;

			}
			else 
			{
				chatObj.setResponse(ConstantAction.INVALID_TOKEN);
				chat.add(chatObj);
				return chat;
			}

		} catch (Exception e) {
			// TODO: handle exception

			//e.printStackTrace();
			chat=null;
		}
		return chat;
	}

	@Override
	public Long getadminMessageCount(@Valid Chat user) {
		// TODO Auto-generated method stub
		Long	chat=0L;
		try {

			chat=chatRepo.countByTokenAndStatus(user.getToken(),2);

		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			chat=0L;
		}
		return chat;
	}

	@Override
	public List<Chat> getAdminNewMessageByToken(@Valid Chat user) {
		// TODO Auto-generated method stub	// TODO Auto-generated method stub
		List<Chat> chat =new ArrayList<>();
		try {
			//chat=	chatRepo.findByTokenOrderByChatIdAsc(user.getToken());
			chat=	chatRepo.findByTokenAndStatusOrderByChatIdDesc(user.getToken(),2);
			if(chat.size()!=0) {
				return chat;
			}

		} catch (Exception e) {
			// TODO: handle exception
			//	e.printStackTrace();
			chat=null;
		}

		return chat;
	}

	@Override
	public Chat logoutTimeout(Chat chat) {
		Chat chatData= new Chat();

		try {
			int	sessionOut	=chatRepo.updatetokenStatus(chat.getToken());

		} catch (Exception e) {
			//e.printStackTrace();
			chatData=null;
		}
		return chatData;
	}

	@Override
	public List<Chat> automaticloginUsingToken(Long token, HttpSession session) {
		List<Chat> chat = new ArrayList<>();
		Chat chatObj = new Chat();
		try {
			//chat=chatRepo.findByTokenOrderByChatIdAsc(user.getToken());
			chat=	chatRepo.findByTokenAndTokenTimeoutOrderByChatIdDesc(token,1);


			if(chat.size()!=0) {
				chat.get(0).setResponse("valid token");
				session.setAttribute(ConstantAction.USER_SESSION, chat.get(0));
				
				Long dataRecord =System.currentTimeMillis();
				AdminNotification notificationTable= new AdminNotification();
				notificationTable.setCreatedOn(String.valueOf(dataRecord));
				notificationTable.setExpiredOn(TimeConverter.getTimeAfter8Hrs(dataRecord));
				notificationTable.setCustomerEmail(chat.get(0).getEmail());
				notificationTable.setDescription(chat.get(0).getSubject());
				notificationTable.setNotificationType(1);
				notificationTable.setStatus(0);
				try {
					notificationTableRepository.save(notificationTable);

				} catch (Exception e) {
				//	e.printStackTrace();
				}

				return chat;

			}
			else 
			{
				chatObj.setResponse(ConstantAction.INVALID_TOKEN);
				chat.add(chatObj);
				return chat;
			}

		} catch (Exception e) {
			// TODO: handle exception

		e.printStackTrace();
			chat=null;
		}
		return chat;
	}





}
