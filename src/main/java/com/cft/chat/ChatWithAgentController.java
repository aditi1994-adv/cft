package com.cft.chat;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.cft.model.AuditLogs;
import com.cft.model.Chat;
import com.cft.model.ChatWithAgent;
import com.cft.model.ShipmentInviteEmail;
import com.cft.repo.AuditLogsRepo;
import com.cft.service.AuditLogsService;
import com.cft.service.ChatWithAgentService;
import com.cft.util.ConstantAction;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Controller
public class ChatWithAgentController {

	@Autowired
	private ChatWithAgentService chatWithAgentService;
	
	@Autowired
	private AuditLogsService auditLogsService;

	/*
	@SuppressWarnings("null")
	@ResponseBody
	@PostMapping("/sendMessageToAgent")
	public String submit(@Valid @ModelAttribute("chatApp")ChatWithAgent user, BindingResult result, Model model,RedirectAttributes redirect) {

		ChatWithAgent listChat=chatWithAgentService.sendMessage(user);
		Gson gson = new Gson();
		if(listChat!=null) {
			if (listChat!=null && listChat.getResponse().equals(ConstantAction.PLEASE_ENTER_MESSAGE)) {
				redirect.addAttribute(ConstantAction.ERROR_MESSAGE, ConstantAction.PLEASE_ENTER_MESSAGE);
				listChat.setResponse(ConstantAction.PLEASE_ENTER_MESSAGE);
				String json = gson.toJson(listChat);
				return json;
			}
			else {
				listChat.setResponse(ConstantAction.EMAIL_SEND);
				redirect.addAttribute(ConstantAction.SUCCESS_MESSAGE, ConstantAction.EMAIL_SEND);
				String json = gson.toJson(listChat);
				return json;
			}
		}
		else {
			listChat.setResponse(ConstantAction.SOMETHING_WENT_WRONG);
			redirect.addAttribute(ConstantAction.ERROR_MESSAGE, ConstantAction.SOMETHING_WENT_WRONG);
			String json = gson.toJson(listChat);
			return json;
		}

	}

	@ResponseBody
	@PostMapping("/loginUsingToken")
	public String loginWithToken(@Valid @ModelAttribute("chatApp")ChatWithAgent user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {
		HttpSession session= request.getSession();
		List<ChatWithAgent> listChat=chatWithAgentService.loginUsingToken(user,session);
		Gson gson = new Gson();
		JsonArray jsonArray = null;
		JsonElement element = gson.toJsonTree(listChat, new TypeToken<List<ChatWithAgent>>() {}.getType());
		jsonArray = element.getAsJsonArray();
		JSONObject jobj = new JSONObject();
		try
		{
			jobj.put("notify", jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobj.toString();
	}




	 */

	@SuppressWarnings("unchecked")
	@ResponseBody
	@PostMapping("/groupChat")
	public String chatUsingToken(@Valid @ModelAttribute("chatApp")ChatWithAgent user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {
		HttpSession session = request.getSession();
		AuditLogs audit = (AuditLogs) session.getAttribute(ConstantAction.CUSTOMER_SESSION);
		JsonArray jsonArray = null;
		if(audit!=null) {
			//check lagana h if null aaye means sseeesion expired
			user.setFromEmail(audit.getEmail());

		}
		ChatWithAgent dataSave=chatWithAgentService.insertChatUsingShipmentid(user);
		List<ChatWithAgent> listChat=chatWithAgentService.getListOfChatByToken(user);
		if(null !=listChat) {
			if( listChat.get(0).getResponse() !=null && listChat.get(0).getResponse().equals(ConstantAction.INVALID_TOKEN)) {
			}
			else {
				Gson gson = new Gson();
				JsonElement element = gson.toJsonTree(listChat, new TypeToken<List<ChatWithAgent>>() {}.getType());
				jsonArray = element.getAsJsonArray();
			}
		}
		else {
			listChat=null;
		}
		JSONObject jobj = new JSONObject();
		try
		{
			jobj.put("notify", jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobj.toString();

	}

	@ResponseBody
	@PostMapping("/getMessagesFromAgent")
	public String getMessagesUsingToken(@Valid @ModelAttribute("checkToken")ChatWithAgent user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {

		JsonArray jsonArray = null;

		List<ChatWithAgent> listChat=chatWithAgentService.getListOfChatByToken(user);
		if(listChat.size()!=0) {
			if( listChat.get(0).getResponse() !=null && listChat.get(0).getResponse().equals(ConstantAction.INVALID_TOKEN)) {
			}
			else {

				Gson gson = new Gson();
				JsonElement element = gson.toJsonTree(listChat, new TypeToken<List<ChatWithAgent>>() {}.getType());
				jsonArray = element.getAsJsonArray();
			}
		}
		else {
			listChat=null;
		}
		JSONObject jobj = new JSONObject();
		try
		{
			jobj.put("notify", jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobj.toString();

	}


	@SuppressWarnings({"unchecked", "unused" })
	@ResponseBody
	@PostMapping("/getLastMessageCountOfAgent")
	public String checkAdminMessageCount(@Valid @ModelAttribute("checkToken")ChatWithAgent user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {
		String json=null;
		JsonArray jsonArray = null;
		Long listChat=chatWithAgentService.getagentMessageCount(user);

		try
		{
			Gson gson = new Gson();
			json = gson.toJson(listChat);


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return json.toString();
		}
		return json.toString();
	}


	@SuppressWarnings({"unchecked", "unused" })
	@ResponseBody
	@PostMapping("/getAgentNewMessage")
	public String getAdminNewMessage(@Valid @ModelAttribute("checkToken")ChatWithAgent user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {

		JsonArray jsonArray = null;
		HttpSession session = request.getSession();
		/*if(session.getAttribute(ConstantAction.USER_SESSION) !=null) {
			ChatW chat=	(Chat) session.getAttribute(ConstantAction.USER_SESSION);
			user.setToken(chat.getToken());
		}*/
		List<ChatWithAgent> listChat=chatWithAgentService.getAgentNewMessageByToken(user);
		if(listChat.size()!=0) {
			if( listChat.get(0).getResponse() !=null && listChat.get(0).getResponse().equals(ConstantAction.INVALID_TOKEN)) {
			}
			else {
				session.setAttribute(ConstantAction.CUSTOMER_SESSION, listChat.get(0));
				Gson gson = new Gson();
				JsonElement element = gson.toJsonTree(listChat, new TypeToken<List<Chat>>() {}.getType());
				jsonArray = element.getAsJsonArray();
			}
		}
		else {
			listChat=null;
		}
		JSONObject jobj = new JSONObject();
		try
		{
			jobj.put("notify", jsonArray);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jobj.toString();

	}


	@ResponseBody
	@GetMapping(value = "/logOut")
	public RedirectView userLogout(HttpServletRequest request, Model model,RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/");
		if (null != session) {
			try {
				if(session.getAttribute(ConstantAction.CUSTOMER_SESSION) !=null) {
					AuditLogs		auditLogs =	(AuditLogs) session.getAttribute(ConstantAction.CUSTOMER_SESSION);
					
		AuditLogs audit=auditLogsService.updateLoggedInStatus(auditLogs);
					session.invalidate();
					
					/*
					shipmentId  and  token get krk  set kro tokentimeout =2
				*/	
						session=null;
						return redirectView;
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return redirectView;


	}
	
	
	@ResponseBody
	@PostMapping("/groupChatNotify")
	public String groupChatNotify(@Valid @ModelAttribute("chatApp")ChatWithAgent user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {
		HttpSession session = request.getSession();
		AuditLogs audit = (AuditLogs) session.getAttribute(ConstantAction.CUSTOMER_SESSION);
		JsonArray jsonArray = null;
		if(audit!=null) {
			//check lagana h if null aaye means sseeesion expired
			user.setFromEmail(audit.getEmail());

		}
		ChatWithAgent dataSave=chatWithAgentService.insertChatUsingShipmentid(user,audit);
		List<ChatWithAgent> listChat=chatWithAgentService.getListOfChatByToken(user);
		if(null !=listChat) {
			if( listChat.get(0).getResponse() !=null && listChat.get(0).getResponse().equals(ConstantAction.INVALID_TOKEN)) {
			}
			else {
				Gson gson = new Gson();
				JsonElement element = gson.toJsonTree(listChat, new TypeToken<List<ChatWithAgent>>() {}.getType());
				jsonArray = element.getAsJsonArray();
				
			}
		}
		else {
			listChat=null;
		}
		JSONObject jobj = new JSONObject();
		try
		{
			jobj.put("notify", jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobj.toString();

	}

	@RequestMapping(value = "/customerdashboard", method = {RequestMethod.POST,RequestMethod.GET})
	public String customerdashboard(/*@ModelAttribute("user")ShippmentDetails ship*/
			@RequestParam String shipmentId,Model model,HttpSession session) {
		
		int chat =chatWithAgentService.updateReadStatus(shipmentId,session);
		if(chat==1) {
			model.addAttribute("shipmentId",shipmentId);
			
			return "customerdashboard";
		}
		else {
model.addAttribute("shipmentId",shipmentId);
			
			return "customerdashboard";
		}
		
		
	}
	
	
	@ResponseBody
	@GetMapping(value = "/clearAgentChat")
	public String clearAgentChat(HttpServletRequest request, Model model,RedirectAttributes redirectAttributes,@RequestParam String shipmentId) {
		HttpSession session = request.getSession(false);
		String str="";
		if (null != session) {
			try {
				/*
				shipmentId  and  token get krk  set kro tokentimeout =2
			*/	
		int audit=chatWithAgentService.updateShipmentStatus(shipmentId);
					
				if(audit==1) {
					str="token_timeout_set";
					
				}
				else {
					str="token_timeout_not_set";
				}
						
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return  str;


	}
	
	

}
