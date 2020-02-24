package com.cft.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;

/**
 * 
 * @author aditi
 *
 */
public class SendMailProperty extends javax.mail.Authenticator {

    public static Session mailProperty() {
    	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    	 final String SERVIDOR_SMTP = "smtp.office365.com";
    	    final int PORTA_SERVIDOR_SMTP = 587;
    	    
        final String username = ConstantAction.FROM_EMAIL_ID;
        final String password = ConstantAction.FROM_PASSWORD;
        Properties props = new Properties();
               
               
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SERVIDOR_SMTP);
        props.put("mail.smtp.port", PORTA_SERVIDOR_SMTP);
      
      
       props.put("mail.user", username); 
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(username, password);
            }

        });
        
      
        return session;
    }

}
