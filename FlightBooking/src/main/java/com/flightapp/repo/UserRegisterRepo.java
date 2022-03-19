package com.flightapp.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.UserRegister;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister,Integer> {

	UserRegister findByPnr(String pnr);
	
	List<UserRegister> findByEmailId(String emailId);
	
	@Transactional
	void removeByPnr(String pnr);
}
