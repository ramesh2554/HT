package com.oms.service;

import java.util.List;
import java.util.Optional;


import com.oms.model.Orders;

public interface OrderService {

	
	Integer saveOrder(Orders Orders);
	
	List<Orders> getAllOrders();
	
	Optional<Orders> getOrderById(Integer id);
	
	Integer updateOrderById(Orders orders);
	
	void deleteByid(Integer id);
}
