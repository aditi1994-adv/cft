package com.cft.util;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailSenderByThread extends Thread{
	public  String toMailId;
	public  String subject;
	public  String msg;

	@Override
	public void run(){  
		try {
			
			Message message = new MimeMessage(SendMailProperty.mailProperty());
			
			message.setFrom(new InternetAddress(ConstantAction.FROM_EMAIL_ID,"CCT Customer Services"));
			//message.setFrom(new InternetAddress(ConstantAction.FROM_EMAIL_ID),"CCT Admin");
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMailId));
			message.setSubject(subject);
			message.setContent(msg, ConstantAction.TEXT_HTML);
			message.addRecipient(RecipientType.BCC, new InternetAddress("aditi.yadav@advantal.net"));
			Transport.send(message);
			
			System.out.println("MailSenderByThread.run() success");

		} catch (MessagingException messagingException) {
			System.out.println("MailSenderByThread.run() "+messagingException);
			messagingException.printStackTrace();

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
