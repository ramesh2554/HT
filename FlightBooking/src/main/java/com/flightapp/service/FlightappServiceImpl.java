package com.flightapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.exception.AdminLoginFailedException;
import com.flightapp.exception.FlightInfoMissedException;
import com.flightapp.model.AdminLoginDetails;
import com.flightapp.model.Flightapp;
import com.flightapp.repo.AdminLoginDetailsRepo;
import com.flightapp.repo.FlightappRepo;

@Service
public class FlightappServiceImpl implements FlightappService {

	@Autowired
	FlightappRepo repo;
	
	@Autowired
	AdminLoginDetailsRepo adminRepo;

	
	@Override
	public Integer saveFlightInfo(Flightapp flightapp) {
		
		
		if(flightapp.getScheduledDays().equalsIgnoreCase("Daily") || 
				flightapp.getScheduledDays().equalsIgnoreCase("WeekDays") || 
				flightapp.getScheduledDays().equalsIgnoreCase("Weekends") ) {
			
			flightapp.setRoundTripCost(flightapp.getTicketCost()*2);
			Flightapp save = repo.save(flightapp);
			Integer FlightNumber = save.getFlightNumber();
			return FlightNumber;
		}else {
			throw new FlightInfoMissedException("Please enter correct details .. !!");
		}
		
		}
		



	@Override
	public Boolean adminLogin(AdminLoginDetails adminlogin) {
		
//		AdminLoginDetails save = adminRepo.save(adminlogin);
//		System.out.println(save);
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