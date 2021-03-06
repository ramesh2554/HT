package com.flightapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.Flightapp;

@Repository
public interface FlightappRepo extends JpaRepository<Flightapp,Integer> {

	
	List<Flightapp> findByFromplaceAndToplace(String from , String to);
}
