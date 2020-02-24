package com.cft.util;

public class EmailTemplate {
	
	public static String getMailBodyTemplate(String name, Long token) {

	
		String email_template = "<!DOCTYPE html>" + 
				"<html><head><title>Delivered to Consignee(update status)</title>"
				+ "<meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'>" + 
				"<style type='text/css'>body{margin: 0px;}</style></head><body>"
				+ "<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0'><tbody><tr><td align='center'>" + 
				"<table class='col-600' width='750' border='0' align='center' cellpadding='0' cellspacing='0' bgcolor='#21356A'"
				+ "style='padding: 45px 0;'> <tbody><tr><td align='center' style='line-height: 0px;'></td></tr>"
				+ "<tr><td align='center' valign='middle'><table class='col-450' width='650'border='0' align='center' "
				+ "cellpadding='0' cellspacing='0'style='padding: 10px 25px; background: #EDF0F3; border-bottom: 1px solid #21356A;'"
				+ "bgcolor='#d8d8d8'><tbody><tr><td><div style='background: #86D3ED; width: 55px; height: 55px; "
				+ "border-radius: 50px; display: inherit;vertical-align: middle; font-size: 18px; color: #fff; "
				+ "font-weight: bold; font-family: 'Lato', sans-serif; text-align: center;'>CCT</div>\r\n" + 
				"</td></tr></tbody></table></td></tr><tr><td align='center' valign='middle'>"
				+ "<table class='col-450' width='650' border='0' align='center'cellpadding='0' cellspacing='0'"
				+ " style='padding: 25px;'bgcolor='#fff'>"
				+ "<tbody><tr><td align='left'style='font-family: 'Raleway', "
				+ "sans-serif; font-size: 17px; color: #000; font-weight: bold;'><b>Dear Valuable Customer "+",</b></td></tr>"
				+ "<tr><td height='10'></td></tr>"
				+ "<tr><td align='left' style='font-family: 'Lato', sans-serif; font-size: 15px; color: #505050;"
				+ " letter-spacing: 0.5px; line-height: 22px; font-weight: 300; text-align: justify;'>"
				+ "We will revert back to you shortly. To continue chatting with us, please login with the given token provided"
				+ "  <b> "+token+"</b></td>"
				+"</tr><tr><td height='10'><a class='btn btn-xs btn-default' data-role='bold' title='Bold' href='http://103.241.146.152:8080/CFT-Website/automaticLogin?token="+token+"'>Click here</a>" + 
				"</td></tr><tr>"
				+ "<td align='left' style='font-family: 'Lato', sans-serif; font-size: 14px; color: #000;"
				+ " line-height: 22px; font-weight: 300; text-align: justify;'>Thanks and Regards,</td></tr>"
				+ "<tr><td align='left' style='font-family: 'Lato', sans-serif; font-size: 14px; color: #000;"
				+ " line-height: 22px; font-weight: 300; text-align: justify;'>CCT Customers Services</td></tr></tbody></table></td></tr>" + 
				"<tr><td height='20'></td></tr><tr><td align='center' valign='middle'>"
				
				+ "</td></tr><tr><td height='20'></td></tr></tbody></table></td></tr></tbody></table></body></html>";
			
		return email_template;
	}

	public static String getMailBodyTemplate(String email, String alphaNumericString) {
		
		

		String email_template = "<!DOCTYPE html>" + 
				"<html><head><title>Delivered to Consignee(update status)</title>"
				+ "<meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'>" + 
				"<style type='text/css'>body{margin: 0px;}</style></head><body>"
				+ "<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0'><tbody><tr><td align='center'>" + 
				"<table class='col-600' width='750' border='0' align='center' cellpadding='0' cellspacing='0' bgcolor='#21356A'"
				+ "style='padding: 45px 0;'> <tbody><tr><td align='center' style='line-height: 0px;'></td></tr>"
				+ "<tr><td align='center' valign='middle'><table class='col-450' width='650'border='0' align='center' "
				+ "cellpadding='0' cellspacing='0'style='padding: 10px 25px; background: #EDF0F3; border-bottom: 1px solid #21356A;'"
				+ "bgcolor='#d8d8d8'><tbody><tr><td><div style='background: #86D3ED; width: 55px; height: 55px; "
				+ "border-radius: 50px; display: inherit;vertical-align: middle; font-size: 18px; color: #fff; "
				+ "font-weight: bold; font-family: 'Lato', sans-serif; text-align: center;'>CCT</div>\r\n" + 
				"</td></tr></tbody></table></td></tr><tr><td align='center' valign='middle'>"
				+ "<table class='col-450' width='650' border='0' align='center'cellpadding='0' cellspacing='0'"
				+ " style='padding: 25px;'bgcolor='#fff'>"
				+ "<tbody><tr><td align='left'style='font-family: 'Raleway', "
				+ "sans-serif; font-size: 17px; color: #000; font-weight: bold;'><b>Dear "+",</b></td></tr>"
				+ "<tr><td height='10'></td></tr>"
				+ "<tr><td align='left' style='font-family: 'Lato', sans-serif; font-size: 15px; color: #505050;"
				+ " letter-spacing: 0.5px; line-height: 22px; font-weight: 300; text-align: justify;'>"
				+ "Your One Time Password<br>"
				+ "<b>  Email:</b> "+email+" <br><b> Password :</b>"+alphaNumericString+"</td>"
				+"</tr><tr><td height='10'></td></tr><tr>"
				+ "<td align='left' style='font-family: 'Lato', sans-serif; font-size: 14px; color: #000;"
				+ " line-height: 22px; font-weight: 300; text-align: justify;'>Thanks and Regards,</td></tr>"
				+ "<tr><td align='left' style='font-family: 'Lato', sans-serif; font-size: 14px; color: #000;"
				+ " line-height: 22px; font-weight: 300; text-align: justify;'>CCT Website team</td></tr></tbody></table></td></tr>" + 
				"<tr><td height='20'></td></tr><tr><td align='center' valign='middle'>"
				
				+ "</td></tr><tr><td height='20'></td></tr></tbody></table></td></tr></tbody></table></body></html>";
			
		return email_template;
	}
}
