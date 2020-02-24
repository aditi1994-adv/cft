package com.cft.util;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.web.multipart.MultipartFile;

public class TimeConverter {
	
	
	
	
	public static  String getMysqlRealScapeStringDec(String str)
	{
	String data = "";
	if (str != null && str.length() > 0) {

	str = str.replace("\\", "\\\\");
	str = str.replace("'", "\\'");
	str = str.replace("\"", "\\\"");
	str = str.replace(",", ".");
	str = str.replace("\0", "\\0");
	str = str.replace("\n", "");
	str = str.replace("\r", "");

	//
	// str = str.replace("\b", "\\b");
	// str = str.replace("\t", "\\t");
	//
	//
	// str = str.replace("\"", "\\\"");
	// str = str.replace("\\x1a", "\\Z");


	data = str;
	}
	return data;
	}
	public static String getTimeAfter8Hrs(Long dataRecord) {
		try {

			Calendar cal = Calendar.getInstance();
			// add 8 hours
			cal.setTimeInMillis(dataRecord);
			cal.add(Calendar.HOUR, 8);

			return String.valueOf(cal.getTimeInMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(System.currentTimeMillis()) ;

	}


	public	static String getAlphaNumericString(int n) 
	{ 

		// chose a Character random from this String 
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz"; 

		// create StringBuffer size of AlphaNumericString 
		StringBuilder sb = new StringBuilder(n); 

		for (int i = 0; i < n; i++) { 

			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index 
			= (int)(AlphaNumericString.length() 
					* Math.random()); 

			// add Character one by one in end of sb 
			sb.append(AlphaNumericString 
					.charAt(index)); 


		} 
		System.out.println("TimeConverter.getAlphaNumericString()"+sb.toString());

		return sb.toString(); 
	} 


	public static String MillisecondToEmailFormat(String millisecond,String timezone )
	{

		String formated_date="";

		if(millisecond.length() !=0)
		{
			long lmili = 0;
			if(millisecond.contains("-")) {
				return millisecond;
			}
			if(millisecond.length() == 10) {

				lmili = Long.parseLong(millisecond)*1000;
			}

			lmili = Long.parseLong(millisecond);

			String date_format = "dd/MM/yyyy EEEE hh:mm a";

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			SimpleDateFormat sdf = new SimpleDateFormat(date_format);

			// sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			sdf.setTimeZone(TimeZone.getTimeZone(timezone));

			formated_date=sdf.format(lmili);
		}

		// //System.out.println(formated_date);

		return formated_date;
	}


	public static String attachmentPath(MultipartFile attachment) {
	
		try {
			byte[] bytes =attachment.getBytes();
			
			long seconds = System.currentTimeMillis();
			String fileName = seconds+attachment.getOriginalFilename();
			BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(ConstantAction.IMG_UPLOAD_PATH +fileName)));
			buffStream.write(bytes);
			buffStream.close();
			return   ConstantAction.IMG_BASE_URL+fileName;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
}
