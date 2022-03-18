package com.flightapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.exception.AdminLoginFailedException;
import com.flightapp.model.AdminLoginDetails;
import com.flightapp.model.Flightapp;
import com.flightapp.service.FlightappService;

@RestController
@RequestMapping("api/v1.0/flight")
public class FlightappController {

	@Autowired
	FlightappService service;

	@GetMapping("/test")
	public String testApplication() {
		return "test";
	}

	@PostMapping("/admin/login")
	public String adminLogin(@RequestBody AdminLoginDetails details) {
		Boolean adminLogin = service.adminLogin(details);
		if (adminLogin) {
			return "LoginSucess";
		} else {
			throw new AdminLoginFailedException("Admin Access Denied ..!! ,, Try Again ...!!!");

		}
	}

	@PostMapping("/airline/inventory/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Integer saveFlightInfo(@RequestBody Flightapp flightapp) {
		return service.saveFlightInfo(flightapp);

	}

	@PostMapping("/search")
	public List<Flightapp> searchFlight(@RequestBody Flightapp flightapp) {
		List<Flightapp> searchFlight = service.searchFlight(flightapp);
		return searchFlight;
	}
}
