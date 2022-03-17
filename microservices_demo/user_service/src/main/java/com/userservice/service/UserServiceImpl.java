package com.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userservice.model.User;

@Service
public class UserServiceImpl implements UserService{

	List<User> list = List.of(
			new User(1311L, "Rameswara", "9876543210"),
			new User(1322L, "Rohit", "8988988899"),
			new User(1333L, "Rameswara", "9090909090"),
			new User(1344L, "Rameswara", "9876543210"));
	
	@Override
	public User getUser(Long id) {
		
		return list.stream().filter(u->u.getUserId().equals(id)).findAny().orElse(null);
	}

}
