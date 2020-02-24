package com.cft.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.cft.model.Chat;

public interface ChatService {

	Chat chattingWithAdmin(@Valid Chat user);

	Chat chatUsingToken(@Valid Chat user);


	List getListByToken(@Valid Chat user);

	List<Chat> loginUsingToken(@Valid Chat user, HttpSession session);

	Long getadminMessageCount(@Valid Chat user);

	List<Chat> getAdminNewMessageByToken(@Valid Chat user);

	Chat logoutTimeout(Chat chat);

	Chat saveImages(MultipartFile[] imgpath);

	List<Chat> automaticloginUsingToken(Long token, HttpSession session);

	

}
