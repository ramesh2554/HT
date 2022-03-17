package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	List<Contact> list = List.of(
			new Contact(1L, "xyz@gmail.com", "Ramesh", 1311L),
			new Contact(2L, "xyz@gmail.com", "Ramesh", 1322L),
			new Contact(3L, "xyz@gmail.com", "Ramesh", 1333L),
			new Contact(4L, "xyz@gmail.com", "Ramesh", 1344L),
			new Contact(5L, "xyz@gmail.com", "Ramesh", 1311L));
	
		
	public List<Contact> getContactofUsers(Long UserId) {
		
		return list.stream().
		filter(c->c.getUserId().equals(UserId)).
		collect(Collectors.toList());
		
		 
	}

}
