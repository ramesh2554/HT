package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.model.Contact;
import com.contact.service.ContactService;

@RestController
@RequestMapping("/contact") // localhost:9092/contact/user/1311
public class ContactController {

	@Autowired
	ContactService service;
	
	@GetMapping("/user/{userId}")
	public List<Contact> getContactofUsers(@PathVariable("userId") Long UserId){
		return service.getContactofUsers(UserId);
		
	}
}
