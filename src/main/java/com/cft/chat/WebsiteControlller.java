package com.cft.chat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cft.model.AuditLogs;
import com.cft.model.ShippmentDetails;
import com.cft.service.ShippmentDetailservice;
import com.cft.util.ConstantAction;


@Controller
public class WebsiteControlller {

	@Autowired
	private  ShippmentDetailservice shipmentDetailService;


	@GetMapping(value = "/advertisement")
	public String advertisement( Model model,HttpServletRequest request,@RequestParam(required=false)String successMessage) {

		HttpSession session = request.getSession();
		AuditLogs user=  (AuditLogs) session.getAttribute(ConstantAction.CUSTOMER_SESSION);
		int shipmentRecord=shipmentDetailService.getShipmentRecordByEmail(user);
		model.addAttribute("shipmentRecord", shipmentRecord);
		if( successMessage!=null) {
			model.addAttribute("successMessage", successMessage);
			return "advertisment";
		}else {

			return "advertisment";
		}
	}




	@GetMapping(value = "/freightforwarding")
	public String index( Model model, HttpServletRequest request) {

		return "freightforwarding";
	}

	@GetMapping(value = "/newpage")
	public String newpage( Model model, HttpServletRequest request) {

		return "newpage";
	}


	@GetMapping(path ="/servicelogin")
	public RedirectView servicelogin(HttpServletRequest request) {

		HttpSession session= request.getSession();
		AuditLogs user=	(AuditLogs) session.getAttribute(ConstantAction.CUSTOMER_SESSION);
		if(user!=null) {
			RedirectView redirectView = new RedirectView();
			redirectView.setContextRelative(true);
			redirectView.setUrl("/redirectedLink");
			return redirectView;

		}
		else {
			RedirectView redirectView = new RedirectView();
			redirectView.setContextRelative(true);
			redirectView.setUrl("/serviceloginView");
			return redirectView;
		}


	}
	@GetMapping(path ="/serviceloginView")
	public String serviceloginPage(HttpServletRequest request) {
		/*ModelAndView mov = new ModelAndView();
		mov.addObject("successMessage", "RegisteredSuccessfully");*/
		return "servicelogin";


	}

	@GetMapping(value = "/document")
	public String slash( Model model, HttpServletRequest request) {

		return "docManagement";
	}


	@GetMapping(value = "/emailMarketing")
	public String emailMarketing( Model model, HttpServletRequest request) {
		return "emailMarketing";
	}



	@GetMapping(value = "/projectManagement")
	public String projectManagement( Model model, HttpServletRequest request) {
		return "projectManagement";
	}


	@RequestMapping(value = {"/about"}, method = RequestMethod.GET)
	public String aboutus(Model model,String successMessage ,String errorMessage) {	
		model.addAttribute("successMessage", successMessage);
		model.addAttribute("errorMessage", errorMessage);
		return "aboutus";
	}
	@RequestMapping(value = {"index","/"}, method = RequestMethod.GET)
	public String index(Model model,String successMessage ,String errorMessage) {	
		model.addAttribute("successMessage", successMessage);
		model.addAttribute("errorMessage", errorMessage);
		return "index";
	}

	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String service(Model model,String successMessage ,String errorMessage) {	
		return "service";
	}

	@RequestMapping(value = "/partner", method = RequestMethod.GET)
	public String partner(Model model,String successMessage ,String errorMessage) {	
		return "partner";
	}


	@RequestMapping(value = "/requestagent", method = RequestMethod.GET)
	public String requestagent(Model model,String successMessage ,String errorMessage) {	
		return "requestagent";
	}
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String news(Model model,String successMessage ,String errorMessage) {	
		return "news";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model,String successMessage ,String errorMessage) {	
		return "contact";
	}






}
