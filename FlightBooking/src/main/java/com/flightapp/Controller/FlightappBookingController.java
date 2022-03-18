package com.flightapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.UserRegister;
import com.flightapp.service.UserRegisterService;

@RestController
@RequestMapping("api/v1.0/flight")

public class FlightappBookingController {

	@Autowired
	UserRegisterService service;
	
	@PostMapping("/booking")
	public String bookFlightTicket(@RequestBody UserRegister register) {
		
		return service.bookFlightTicket(register);
		 
	}
	
}
