package com.cft.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.cft.model.AuditLogs;
import com.cft.model.ChatWithAgent;

public interface ChatWithAgentService {

	/*ChatWithAgent sendMessage(@Valid ChatWithAgent user);

	List<ChatWithAgent> loginUsingToken(@Valid ChatWithAgent user, HttpSession session);

	List<ChatWithAgent> getListOfChatByToken(@Valid ChatWithAgent user);*/

	

	ChatWithAgent insertChatUsingShipmentid(@Valid ChatWithAgent user);

	List<ChatWithAgent> getListOfChatByToken(@Valid ChatWithAgent user);

	Long getagentMessageCount(@Valid ChatWithAgent user);

	List<ChatWithAgent> getAgentNewMessageByToken(@Valid ChatWithAgent user);

	ChatWithAgent insertChatUsingShipmentid(@Valid ChatWithAgent user, AuditLogs audit);

	int updateReadStatus(String shipmentId, HttpSession session);

	int updateShipmentStatus(String shipmentId);

	
	
	}
