package com.dicksonthedeveloper.mailserver.service;

import com.dicksonthedeveloper.mailserver.model.SendMailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailService {

    @Qualifier("getJavaMailSender")
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String to;

    public void sendEmail(SendMailRequest sendMailRequest) {
        String text = sendMailRequest.getMessage() + "\nFrom " + sendMailRequest.getSenderName();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sendMailRequest.getSenderEmail());
        mailMessage.setTo(to);
        mailMessage.setSubject(sendMailRequest.getSubject());
        mailMessage.setText(text);
        mailSender.send(mailMessage);

        System.out.println("Sent message successfully....");
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            message.setSubject("Mail From Spring Boot MailServer");
//
//            // Now set the actual message
//            message.setText("This is actual message");
//
//            // Send message
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
    }
}
