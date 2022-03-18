package com.flightapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Flightapp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightNumber;
	
	private String airline;
	private String fromplace;
	private String toplace;

	//@Temporal(TemporalType.DATE)
	private Date startDate;

	//@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private String scheduledDays;
	
	private int totalBusinessClassSeats;
	
	private int totalNonBusinessClassSeats;
	
	private double ticketCost;
	
	private double roundTripCost;
	
	private int numberofRows;
	
	private String mealType;
}
