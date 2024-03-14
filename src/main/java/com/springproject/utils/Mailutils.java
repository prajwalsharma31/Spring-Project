package com.springproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class Mailutils {
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail(String toemail , String subject , String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("to_1@gmail.com", "to_2@gmail.com", "to_3@yahoo.com");

        msg.setSubject(toemail);
        msg.setSubject(subject);
        msg.setText(message);

        javaMailSender.send(msg);

    }

}
