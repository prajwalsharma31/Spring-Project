package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.utils.Mailutils;

@Controller
public class Contactcontroller {
	@Autowired
	private Mailutils  mailutil;
	
	@GetMapping("/contact")
	public String getcontact() {
		
		return "ContactForm";
	}
	@PostMapping("/contact")
	public String postcontact(@RequestParam String toemail , @RequestParam String subject , @RequestParam String message) {
		mailutil.sendEmail(toemail, subject, message);
		
		return "ContactForm";
	}

}
