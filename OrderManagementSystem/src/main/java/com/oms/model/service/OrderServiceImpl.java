package com.oms.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.model.Orders;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired 
	OrderServiceRepo repo;
	
	@Override
	public Integer saveOrder(Orders orders) {
		Orders save = repo.save(orders);
		return save.getId() ;
	}

	@Override
	public List<Orders> getAllOrders() {
		
		return repo.findAll();
	}

	@Override
	public Optional<Orders> getOrderById(Integer id) {
		
		return repo.findById(id);
	}

	
	public Integer updateOrderById(Orders orders) {
		
		Orders save = repo.save(orders);
		return save.getId();
	}

	@Override
	public void deleteByid(Integer id) {
		
		System.out.println("Deleted " + id);
		repo.deleteById(id);
		
	}

}
