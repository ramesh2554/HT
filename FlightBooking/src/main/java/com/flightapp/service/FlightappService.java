package com.flightapp.service;

import java.util.List;

import com.flightapp.model.AdminLoginDetails;
import com.flightapp.model.Flightapp;

public interface FlightappService {

	Integer saveFlightInfo(Flightapp flightapp);
	
	Boolean adminLogin(AdminLoginDetails adminlogin);
	
	List<Flightapp> searchFlight(Flightapp flightapp);
}
