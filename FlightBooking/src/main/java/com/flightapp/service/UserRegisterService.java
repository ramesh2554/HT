package com.flightapp.service;

import java.util.List;

import com.flightapp.model.UserRegister;

public interface UserRegisterService {

	String bookFlightTicket(UserRegister register , Integer id);

	UserRegister getBookingDetails(String pnr);

	List<UserRegister> getBookingDetailsBasedOnEmail(String emailId);

	void deleteBookingDetails(String pnr);

	
}
