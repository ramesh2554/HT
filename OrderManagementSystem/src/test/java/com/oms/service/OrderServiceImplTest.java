package com.oms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.oms.model.Orders;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

	@InjectMocks
	OrderServiceImpl orderServiceImpl;
	
	@Mock
	OrderServiceRepo repo ;
	

	@Test
	void testSaveOrder() {
		Orders order = new Orders();
		order.setId(1);
		when(repo.save(order)).thenReturn(order);
		Integer saveOrder = orderServiceImpl.saveOrder(order);
		assertEquals(1, saveOrder);
		
	}
	
	@Test
	void testGetAllOrders() {
		Orders orders1 = new Orders(1,"java",99);
		Orders orders2 = new Orders(2,"java",99);
		List<Orders> ordersList = new ArrayList<>();
		ordersList.add(orders1);
		ordersList.add(orders2);
		when(repo.findAll()).thenReturn(ordersList);
		List<Orders> allOrders = orderServiceImpl.getAllOrders();
		assertEquals(ordersList, allOrders);
	}

}
