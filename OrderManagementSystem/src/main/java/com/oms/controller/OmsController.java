package com.oms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.oms.model.Orders;
import com.oms.model.service.OrderService;

@RestController
public class OmsController {

	@Autowired
	OrderService service;
	
	@PostMapping("add")
	public Integer addOrders(@RequestBody Orders Orders) {

		Integer id = service.saveOrder(Orders);
		System.out.println(id);
		return id;
	} 
	
	@GetMapping("allOrders")
	public List<Orders> getAllOrders(){
		
		return service.getAllOrders();
	}
	
	@GetMapping("allOrders/{id}")
	public Optional<Orders> getOrderById(@PathVariable Integer id){
		
		return service.getOrderById(id);
	}
	@PutMapping("updateOrders/{id}")
	public Integer updateOrderById( @RequestBody Orders orders , @PathVariable Integer id){
		
		 return service.updateOrderById(orders);
	}
	
	

}
