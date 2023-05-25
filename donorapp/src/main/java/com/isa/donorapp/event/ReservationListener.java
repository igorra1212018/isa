package com.isa.donorapp.event;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.isa.donorapp.model.User;
import com.isa.donorapp.service.UserService;

@Component
public class ReservationListener implements 
  ApplicationListener<OnReservationCompleteEvent> {
 
    @Autowired
    private MessageSource messages;
 
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(OnReservationCompleteEvent event) {
    	try {
    		this.sendEmailWithQRCode(event);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void sendEmailWithQRCode(OnReservationCompleteEvent event) throws MessagingException {
    	User user = event.getUser();
    	String recipientEmail = user.getEmail();
    	String subject = "Reservation confirmation";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(recipientEmail);
        helper.setSubject(subject);

        String qrCodeHtml = "<html><body><img src='data:image/png;base64," + event.getQRCode() + "'></body></html>";
        helper.setText(qrCodeHtml, true);

        mailSender.send(message);
        
    }
}
