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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cft.model.Chat;
import com.cft.service.ChatService;
import com.cft.util.ConstantAction;
import com.cft.util.MailSenderByThread;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Controller
//@RestController
public class ChatController {

	@Autowired
	private ChatService chatService;

	  
	//Upload_Multiple_Images
	 @PostMapping("/images")
	 public Chat uploadImages(@RequestParam(value="imgpath")MultipartFile[] imgpath) throws Exception
	 {
	 Chat iResponse = chatService.saveImages(imgpath);
	 System.out.println("UserController.uploadImages()"+iResponse);
	return iResponse;
	}
	 
	//Upload_Multiple_Images
		 @GetMapping("/testEmail")
		 public String testEmail() throws Exception
		 {
			 
				MailSenderByThread mailSenderByThread = new MailSenderByThread();
				mailSenderByThread.toMailId ="aditi.yadav@advantal.net";
				mailSenderByThread.msg ="message test";
				mailSenderByThread.subject=" subject";
				mailSenderByThread.start();
		
		return "";
		}
	

	@SuppressWarnings("null")
	@ResponseBody
	@PostMapping("/chat")
	public String submit(@Valid @ModelAttribute("chatApp")Chat user, BindingResult result, Model model,RedirectAttributes redirect) {
		Chat listChat=chatService.chattingWithAdmin(user);
		Gson gson = new Gson();
		if(listChat!=null) {
			if (listChat!=null && listChat.getResponse().equals(ConstantAction.PLEASE_ENTER_MESSAGE)) {
				redirect.addAttribute(ConstantAction.ERROR_MESSAGE, ConstantAction.PLEASE_ENTER_MESSAGE);
				listChat.setResponse(ConstantAction.PLEASE_ENTER_MESSAGE);
				String json = gson.toJson(listChat);
				return json;
			}
			
			else if (listChat!=null && listChat.getResponse().equals(ConstantAction.ENTER_EMAIL)) {
					redirect.addAttribute(ConstantAction.ERROR_MESSAGE, ConstantAction.ENTER_EMAIL);
					listChat.setResponse(ConstantAction.ENTER_EMAIL);
					String json = gson.toJson(listChat);
					return json;
				}
			
			else {
				listChat.setResponse(ConstantAction.EMAIL_SEND);
				redirect.addAttribute(ConstantAction.SUCCESS_MESSAGE, ConstantAction.EMAIL_SEND);
				//return	listChat.toString();
				String json = gson.toJson(listChat);
				return json;
			}
		}
		else {
			Chat chat= new Chat();
			chat.setResponse(ConstantAction.SOMETHING_WENT_WRONG);
			redirect.addAttribute(ConstantAction.ERROR_MESSAGE, ConstantAction.SOMETHING_WENT_WRONG);
			//return	listChat.toString();
			String json = gson.toJson(chat);
			return json;
		}

	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@PostMapping("/loginWithToken")
	public String loginWithToken(@Valid @ModelAttribute("chatApp")Chat user,
			HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {

		HttpSession session= request.getSession();
		List<Chat> listChat=chatService.loginUsingToken(user,session);
		Gson gson = new Gson();
		JsonArray jsonArray = null;
		JsonElement element = gson.toJsonTree(listChat, new TypeToken<List<Chat>>() {}.getType());
		jsonArray = element.getAsJsonArray();
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
	
	
	
	/*@SuppressWarnings("unchecked")
	@ResponseBody*/
	@GetMapping("/automaticLogin")
	public String automaticLogin(@RequestParam Long token ,HttpServletRequest request, 
			 Model model,RedirectAttributes redirect) {

		HttpSession session= request.getSession();
		model.addAttribute("token", token);
		/*List<Chat> listChat=chatService.automaticloginUsingToken(token,session);
		Gson gson = new Gson();
		JsonArray jsonArray = null;
		JsonElement element = gson.toJsonTree(listChat, new TypeToken<List<Chat>>() {}.getType());
		jsonArray = element.getAsJsonArray();
		JSONObject jobj = new JSONObject();
		try
		{
			jobj.put("notify", jsonArray);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		return "index";

	}
	
	


	@SuppressWarnings("unchecked")
	@ResponseBody
	@PostMapping("/chatWithAdmin")
	public String chatUsingToken(@Valid @ModelAttribute("chatApp")Chat user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {

		HttpSession session = request.getSession();
		Chat chat=	(Chat) session.getAttribute(ConstantAction.USER_SESSION);
		user.setToken(chat.getToken());
		Chat listChat=chatService.chatUsingToken(user);
		if(listChat!=null) {
			return listChat.toString();
			
		}
		else {
			return null;
		}
		
		

	}

	@SuppressWarnings({ "unchecked", "unused" })
	@ResponseBody
	@PostMapping("/checkToken")
	public String checkToken(@Valid @ModelAttribute("checkToken")Chat user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {

		JsonArray jsonArray = null;
		HttpSession session = request.getSession();
		if(session.getAttribute(ConstantAction.USER_SESSION) !=null) {
			Chat chat=	(Chat) session.getAttribute(ConstantAction.USER_SESSION);
			user.setToken(chat.getToken());
		}
		List<Chat> listChat=chatService.getListByToken(user);

		if(null !=listChat) {
			if( listChat.get(0).getResponse() !=null && listChat.get(0).getResponse().equals(ConstantAction.INVALID_TOKEN)) {
			}
			else {
				session.setAttribute(ConstantAction.USER_SESSION, listChat.get(0));
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

	@SuppressWarnings({"unchecked", "unused" })
	@ResponseBody
	@PostMapping("/getLastMessageCountOfAdmin")
	public String checkAdminMessageCount(@Valid @ModelAttribute("checkToken")Chat user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {
		String json=null;
		JsonArray jsonArray = null;
		Long listChat=chatService.getadminMessageCount(user);
	
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
	@PostMapping("/getAdminNewMessage")
	public String getAdminNewMessage(@Valid @ModelAttribute("checkToken")Chat user,HttpServletRequest request, BindingResult result, Model model,RedirectAttributes redirect) {
		
		JsonArray jsonArray = null;
		HttpSession session = request.getSession();
		if(session.getAttribute(ConstantAction.USER_SESSION) !=null) {
			Chat chat=	(Chat) session.getAttribute(ConstantAction.USER_SESSION);
			user.setToken(chat.getToken());
		}
		List<Chat> listChat=chatService.getAdminNewMessageByToken(user);
		if(listChat.size()!=0) {
			if( listChat.get(0).getResponse() !=null && listChat.get(0).getResponse().equals(ConstantAction.INVALID_TOKEN)) {
			}
			else {
				session.setAttribute(ConstantAction.USER_SESSION, listChat.get(0));
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


	
	/*@GetMapping(value = "/error")
	public String error( Model model, HttpServletRequest request) {
		return "error";
	}
*/

	@GetMapping(value = "/newindex")
	public String index( Model model, HttpServletRequest request) {
		model.addAttribute("chat", new Chat());
		return "NewIndex";
	}

	@GetMapping(value = "/admin")
	public String admin( Model model, HttpServletRequest request) {

		model.addAttribute("chat", new Chat());
		return "admin";
	}

	@GetMapping(value = "/adiiti")
	public String slash( Model model, HttpServletRequest request) {
		model.addAttribute("chat", new Chat());
		return "adiiti";
	}

	/**
	 * @author Aditi, Add User Logout Method .
	 * 
	 * expire loginToken after clearChat
	 */
	@ResponseBody
	@GetMapping(value = "/clearChat")
	public String userLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
	Chat chat = new Chat();
	Gson gson = new Gson();
		if (null != session) {
			try {
					if(session.getAttribute(ConstantAction.USER_SESSION) !=null) {
						chat =	(Chat) session.getAttribute(ConstantAction.USER_SESSION);
						
				 	chat =	chatService.logoutTimeout(chat);
					if(chat!=null) {
						if(chat.getTokenTimeout()==0) {
							chat.setResponse(ConstantAction.SESSION_EXPIRED);
//							listChat.setResponse(ConstantAction.PLEASE_ENTER_MESSAGE);
							String json = gson.toJson(chat);
							session.invalidate();
							//session.removeAttribute(ConstantAction.USER_SESSION);
							session=null;
							return json;
						}
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				chat=null;
			}
			
		
		}
		//return "redirect:"+"/";
		else {
			chat.setResponse(ConstantAction.SOMETHING_WENT_WRONG);
			
			
		}
		String json = gson.toJson(chat);
		return json;
		
	}


	/**
	 * @author 
	 */
	/*	@ResponseBody
	@GetMapping(value = ConstantAction.LIST_CHAT)
	public String verificationLink( Model model, HttpServletRequest request) {
	Chat chat=	(Chat) request.getAttribute(ConstantAction.USER_SESSION);
		List listChat=chatService.getListByToken(chat);
		model.addAttribute("listChat", listChat);

		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(listChat, new TypeToken<List<Chat>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
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
	 */




}
