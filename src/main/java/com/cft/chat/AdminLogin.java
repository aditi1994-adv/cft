/*package com.cft.chat;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cft.model.Chat;
import com.cft.repo.ChatRepository;

@Controller
public class AdminLogin {
	@Autowired
	private  ChatRepository chat;
	
	@GetMapping(value = "/admin")
	public String admin( Model model, HttpServletRequest request) {

		model.addAttribute("chat", new Chat());
		return "admin";
	}
	
	@PostMapping("/adminToSender")
	public String submit(@Valid @ModelAttribute("chat")Chat user, BindingResult result, Model model) {
		System.err.println("aditi");
		Chat listChat=chat.save(user);
	
		return "redirect:"+"/admin";

	}

	
	
	
}
*/