package com.fpoly.Service;

import java.util.List;

import com.fpoly.Entity.Users;

public interface UserService {
	
	List<Users>findAll();
	
	Users findByUsername(String username);

	Users findById(Integer id);
	
	Users save(Users us);
	
	void delete(Integer us);
	
	Users getUserCookie();
}
