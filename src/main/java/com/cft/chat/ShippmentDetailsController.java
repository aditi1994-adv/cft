package com.cft.chat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cft.model.ShippmentDetails;
import com.cft.service.ShippmentDetailservice;

@Controller
public class ShippmentDetailsController {
	
	@Autowired
	private  ShippmentDetailservice shipmentDetailService;
	
	
	@ResponseBody
	@PostMapping(path ="/shipment")
	public ShippmentDetails submit(@ModelAttribute("shipment")ShippmentDetails user,BindingResult reult,HttpServletRequest request) {
	
	ShippmentDetails shippmentDetails=shipmentDetailService.getDetailsByShippmentId(user);
		System.out.println("shippmentDetails "+shippmentDetails);
		return shippmentDetails ;

	}

}
