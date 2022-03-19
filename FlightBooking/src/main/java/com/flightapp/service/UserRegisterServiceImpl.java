package com.flightapp.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.model.Flightapp;
import com.flightapp.model.UserRegister;
import com.flightapp.repo.FlightappRepo;
import com.flightapp.repo.UserRegisterRepo;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	@Autowired
	UserRegisterRepo userRegisterRepo;
	
	@Autowired 
	FlightappRepo flightappRepo;

	
	public String bookFlightTicket(UserRegister register , Integer flightNumber) {
		
		Optional<Flightapp> findById = flightappRepo.findById(flightNumber);
//		System.out.println("------------------------" + findById);
		if(findById.isPresent()) {
			
			register.setFlightNumber(flightNumber);
			Random rnd = new Random();
		    int number = rnd.nextInt(999999);
		    String pnr = String.format("%06d", number);
			register.setPnr(pnr);
			userRegisterRepo.save(register);
			return " PNR " + register.getPnr();
		}
			return "Login Failed";
	}


	@Override
	public UserRegister getBookingDetails(String pnr) {
		
		UserRegister findByPnr = userRegisterRepo.findByPnr(pnr);
		System.out.println("----------------" + findByPnr);
		return findByPnr;
	}


	@Override
	public List<UserRegister> getBookingDetailsBasedOnEmail(String emailId) {
		List<UserRegister> findByEmailId = userRegisterRepo.findByEmailId(emailId);
		
		System.out.println("----------------" + findByEmailId);
		
		return findByEmailId;
	}


	@Override
	public void deleteBookingDetails(String pnr) {
		userRegisterRepo.removeByPnr(pnr);
	}

}
