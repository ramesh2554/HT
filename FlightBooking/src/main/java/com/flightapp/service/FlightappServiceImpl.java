package com.flightapp.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.exception.AdminLoginFailedException;
import com.flightapp.model.AdminLoginDetails;
import com.flightapp.model.Flightapp;
import com.flightapp.repo.AdminLoginDetailsRepo;
import com.flightapp.repo.FlightappRepo;
import com.flightapp.utility.Utility;

@Service
public class FlightappServiceImpl implements FlightappService {

	@Autowired
	FlightappRepo repo;
	
	@Autowired
	AdminLoginDetailsRepo adminRepo;

	
	@Override
	public Integer saveFlightInfo(Flightapp flightapp) {
		
		Flightapp save = repo.save(flightapp);
			int flightNumber = save.getFlightNumber();
			return flightNumber;
		}
		



	@Override
	public Boolean adminLogin(AdminLoginDetails adminlogin) {
		
		AdminLoginDetails save = adminRepo.save(adminlogin);
		if(adminlogin.getUsername().equalsIgnoreCase("admin")==adminlogin.getPassword().equalsIgnoreCase("admin")) {
			return true;
		}
		else {
			throw new AdminLoginFailedException("Admin Access Denied ..!! ,, Try Again ...!!!");
		}
		
		
	}




	@Override
	public List<Flightapp> searchFlight(Flightapp flightapp) {
		
		List<Flightapp> findByFromplaceAndToplace = repo.findByFromplaceAndToplace(flightapp.getFromplace(), flightapp.getToplace());
		return findByFromplaceAndToplace;
	}

	
}