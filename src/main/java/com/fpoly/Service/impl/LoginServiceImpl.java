package com.fpoly.Service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.fpoly.DAO.UserDAO;
import com.fpoly.Entity.Users;
import com.fpoly.Service.CookieService;
import com.fpoly.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDAO dao;

//	@Autowired
//	HashPass hashPass;

	@Autowired
	BCryptPasswordEncoder pe;
	
	@Autowired
	HttpSession session;

	@Autowired
	CookieService cookie;

	@Override
	public Users loginByUsername(Users user) {

		return null;
	}

	@Override
	public <S extends Users> S save(S entity) {
		// List<Users> list = dao.findByUsername(entity.getUsername());

		entity.setPassword(pe.encode(entity.getPassword()));
		return dao.save(entity);
	}

	@Override
	public Users findByUsers(String us) {

		return dao.findByUsernameLike(us);
	}

	@Override
	public Boolean Login(Users us) {
		Users u = dao.findByUsernameLike(us.getUsername().trim());

		if (u != null ) {
			Boolean checkPass = pe.matches(us.getPassword(), u.getPassword()); 
			//us -> password user nhập vào : u -> password user trong DB đã hash
			if (u.getUsername().equals(us.getUsername()) && checkPass == true) {
				// sessionService.set("user", u);
				cookie.add("uName", u.getUsername(), 10);
				cookie.add("uPass", u.getPassword(), 10);
				return true;
			}
		}
		return false;
	}
}
