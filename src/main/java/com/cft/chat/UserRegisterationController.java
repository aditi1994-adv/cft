package com.cft.chat;

import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cft.model.AuditLogs;
import com.cft.model.ChatWithAgent;
import com.cft.model.ShipmentInviteEmail;
import com.cft.model.ShippmentDetails;
import com.cft.service.AuditLogsService;
import com.cft.service.ChatWithAgentService;
import com.cft.service.ShipmentInviteEmailService;
import com.cft.service.ShippmentDetailservice;
import com.cft.util.ConstantAction;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Controller
public class UserRegisterationController {


	
	@Autowired
	private ShipmentInviteEmailService siService;

	@Autowired
	private  ShippmentDetailservice shipmentDetailService;

	@Autowired
	private  AuditLogsService auditLogsService;



	@ResponseBody
	@PostMapping("/custRegisteration")
	public String userRegisteration(@Valid @ModelAttribute("user")ShipmentInviteEmail user,BindingResult result) {

		Gson gson = new Gson();
		JSONObject jobj = new JSONObject();
		JsonArray jsonArray = null;
		List<ShipmentInviteEmail>	 customerDetails=siService.getRecordByEmail(user);
		if(customerDetails.size()!=0) {
			
			
			JsonElement element = gson.toJsonTree(customerDetails, new TypeToken<List<ShipmentInviteEmail>>() {}.getType());
			jsonArray = element.getAsJsonArray();
		
			try
			{
				jobj.put("notify", jsonArray);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return jobj.toString();
		}
		else {
			jobj.put("notify", jsonArray);
			return jobj.toString();
		}
		

	}



	@PostMapping("/customerLogin")
	public RedirectView   customerLogin(@Valid @ModelAttribute("user")AuditLogs user,BindingResult result,HttpServletRequest request,Model mov) {
		HttpSession session= request.getSession();
		
	
		AuditLogs userData =auditLogsService.getUserDetail(user);
		if(userData!=null) {
			session.setAttribute(ConstantAction.CUSTOMER_SESSION, userData);
			RedirectView redirectView = new RedirectView();
			redirectView.setContextRelative(true);
			redirectView.setUrl("/redirectedLink");
			
			return redirectView;
		}
		else {
			RedirectView redirectView = new RedirectView();
			redirectView.setContextRelative(true);
			redirectView.setUrl("/servicelogin");
			mov.addAttribute("errorMessage", "User Not Found");
		return redirectView;
		}

		

	}
	
	@GetMapping("/redirectedLink")
	public String   redirectedLink(HttpServletRequest request,Model mov) {
		HttpSession session= request.getSession();
		AuditLogs user=	(AuditLogs) session.getAttribute(ConstantAction.CUSTOMER_SESSION);
	
		List<ShippmentDetails>	 shipmentRecord= new ArrayList<ShippmentDetails>();
		ModelAndView model = new ModelAndView("shipmentHistory");
			shipmentRecord=shipmentDetailService.getShipmentRecordByEmail(user,user.getTimeZone());
			if(shipmentRecord.size()!=0) {
		   model.addObject("shipmentRecord", "shipmentRecord");
			mov.addAttribute("shipmentRecord", shipmentRecord);
			}
			return "shipmentHistory";
		}
		
		

		

	


}
