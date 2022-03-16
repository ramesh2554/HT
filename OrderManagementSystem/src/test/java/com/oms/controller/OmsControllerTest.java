package com.oms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.oms.model.Orders;
import com.oms.service.OrderService;

@ExtendWith(MockitoExtension.class)
class OmsControllerTest {

	@InjectMocks
	OmsController omsController;
	
	@Mock
	OrderService service;
	
	@Test
	void testaddOrders() {
		
		Orders orders = new Orders();
		orders.setId(1);
		when(service.saveOrder(orders)).thenReturn(1);
		Integer addOrders = omsController.addOrders(orders);
		assertEquals(1, addOrders);
	}

	@Test
	void testgetAllOrders() {
		Orders orders1 = new Orders(1,"java",99);
		Orders orders2 = new Orders(2,"java",99);
		List<Orders> ordersList = new ArrayList<>();
		ordersList.add(orders1);
		ordersList.add(orders2);
		when(service.getAllOrders()).thenReturn(ordersList);
		List<Orders> allOrders = omsController.getAllOrders();
		assertEquals(ordersList, allOrders);
		
		
	}
	
	@Test
	public void testGetOrderById() {
		Orders orders = new Orders(1,"java",99);
		Optional<Orders> orderById = service.getOrderById(1);
		when(service.getOrderById(orders.getId())).thenReturn(orderById);
		assertEquals(omsController.getOrderById(1), orderById);
	}
}
