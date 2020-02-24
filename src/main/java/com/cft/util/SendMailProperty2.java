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
public class SendMailProperty2 extends javax.mail.Authenticator {

    public static Session mailProperty() {
    	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        final String username = ConstantAction.FROM_EMAIL_ID;
        final String password = ConstantAction.FROM_PASSWORD;
        Properties props = new Properties();
        
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "false");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        
       
        
       
           
               
               
         
      
        // props.put("mail.smtp.socketFactory.fallback", "false");
       /* props.put(ConstantAction.PROP_SMTP_HOST, ConstantAction.SMTP_HOST);
        props.put(ConstantAction.PROP_SMTP_AUTH, ConstantAction.SMTP_AUTH);
        props.put(ConstantAction.PROP_SMTP_PORT, ConstantAction.SMTP_PORT);
        props.put(ConstantAction.PROP_SMTP_SOCKET_FACTORY, ConstantAction.SMTP_SOCKET_FACTORY);
       props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.fallback", "true");*/ // Should be true
       props.put("mail.user", username); 
        //props.put("mail.user", "CCT Admin"); 
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(username, password);
            }

        });
        
      
        return session;
    }

}
