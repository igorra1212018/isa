package com.isa.donorapp.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender mailSender;
	
    public void sendEmailWithQRCode(String recipientEmail, String qrCodeBase64) throws MessagingException {
    	String subject = "Reservation confirmation";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(recipientEmail);
        helper.setSubject(subject);

        String qrCodeHtml = "<html><body><img src='data:image/png;base64," + qrCodeBase64 + "'></body></html>";
        helper.setText(qrCodeHtml, true);

        mailSender.send(message);
        
    }
}
