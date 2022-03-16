package com.oms.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.oms.model.Orders;

public interface OrderService {

	
	Integer saveOrder(Orders Orders);
	
	List<Orders> getAllOrders();
	
	Optional<Orders> getOrderById(Integer id);
	
	Integer updateOrderById(Orders orders);
	
	void deleteByid(Integer id);
}
