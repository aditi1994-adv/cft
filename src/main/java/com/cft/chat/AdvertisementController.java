package com.cft.chat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.cft.model.Advertisement;
import com.cft.model.AuditLogs;
import com.cft.service.AdvertisementService;
import com.cft.util.ConstantAction;


@Controller
public class AdvertisementController {

	@Autowired
	private AdvertisementService  adService;

	@PostMapping("/saveAdvertisement")
	public RedirectView uploadImages(HttpServletRequest request,@RequestParam(value="excelpath")MultipartFile excelpath,
			@RequestParam(value="attachment")MultipartFile attachment,Advertisement ad,Model model) throws Exception
	{
		HttpSession session = request.getSession();
		AuditLogs email=  (AuditLogs) session.getAttribute(ConstantAction.CUSTOMER_SESSION);

		ad.setCustomerEmail(email.getEmail());
		Advertisement iResponse = adService.sendEmails(excelpath,ad,attachment);
		if(iResponse!=null) {
			model.addAttribute("successMessage", "success");
			RedirectView redirectView = new RedirectView();
			redirectView.setContextRelative(true);
			redirectView.setUrl("/advertisement");

			return redirectView;

		}
		return null;

	}




}
