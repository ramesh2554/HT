package com.flightapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.UserRegister;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister,Integer> {

}
