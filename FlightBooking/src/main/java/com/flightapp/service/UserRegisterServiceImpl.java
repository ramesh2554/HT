package com.flightapp.service;

import java.util.Optional;

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

	@Override
	public String bookFlightTicket(UserRegister register) {
		// TODO Auto-generated method stub
		register.setPnr("12345");
		userRegisterRepo.save(register);
		return " PNR " + register.getPnr();
	}

}
