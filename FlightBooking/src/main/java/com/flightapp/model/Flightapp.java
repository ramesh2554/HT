package com.flightapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;

@Entity
@Data
public class Flightapp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightNumber;
	private String airline;
	private String fromplace;
	private String toplace;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime startDate;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime endDate;
	private String scheduledDays;
	private int totalBusinessClassSeats;
	private int totalNonBusinessClassSeats;
	private double ticketCost;
	private int numberofRows;
	private String mealType;
}
