package com.cft.util;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class MailSenderByThread2 extends Thread{
	public  String toMailId;
	public  String subject;
	public  String msg;
	public  String filename;

	@Override
	public void run(){  
		try {
			
		
				Message message = new MimeMessage(SendMailProperty.mailProperty());
			message.setFrom(new InternetAddress(ConstantAction.FROM_EMAIL_ID));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMailId));
			message.setSubject(subject);
			//message.setContent(msg, ConstantAction.TEXT_HTML);
			message.addRecipient(RecipientType.BCC, new InternetAddress("aditi.yadav@advantal.net"));
			 // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText(msg);

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	       
	         try {
	        	 DataSource source = new FileDataSource(filename);
		          
		         messageBodyPart.setDataHandler(new DataHandler(source));
		         messageBodyPart.setFileName(filename);
		         multipart.addBodyPart(messageBodyPart);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	       

	         // Send the complete message parts
	         message.setContent(multipart);
	     	
			Transport.send(message);

		} catch (MessagingException messagingException) {
			System.out.println("MailSenderByThread.run() "+messagingException);
		
		}

	}

}
