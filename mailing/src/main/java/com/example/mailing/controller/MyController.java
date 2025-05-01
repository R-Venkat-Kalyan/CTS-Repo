package com.example.mailing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("")
	public String home() {
		return "index";
	}
	
	@Autowired
	private JavaMailSender javaMailSender;
	
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }
    
    @GetMapping("send")
    public String sendEmail() {
        String to = "2100030959cseh@gmail.com";
        String subject = "Test Email";
        String text = "This is a test email sent from a Spring Boot application.";

        sendEmail(to, subject, text);
        System.out.println("Nice");
        return "Success";
    }


}
