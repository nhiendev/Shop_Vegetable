package com.fpoly.Service;

import com.fpoly.Entity.Users;

public interface LoginService {

	Users findByUsers(String us);
	
	
	Users loginByUsername(Users us);
	
	<S extends Users> S save(S entity);
	
	void Login(Users us);
	
	void Logout();
}
