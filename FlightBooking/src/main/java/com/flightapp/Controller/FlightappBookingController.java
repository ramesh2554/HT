package com.flightapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.service.FlightappService;

@RestController
@RequestMapping("api/v1.0/flight")

public class FlightappBookingController {

	@Autowired
	FlightappService service;
	
}
