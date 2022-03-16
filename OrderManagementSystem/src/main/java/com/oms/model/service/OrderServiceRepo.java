package com.oms.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.model.Orders;

@Repository
public interface OrderServiceRepo extends JpaRepository<Orders, Integer> {

}
