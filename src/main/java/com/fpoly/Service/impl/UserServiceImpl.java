package com.fpoly.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.DAO.UserDAO;
import com.fpoly.Entity.Users;
import com.fpoly.Service.CookieService;
import com.fpoly.Service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO dao;

	@Autowired
	CookieService cookieService;
	
	@Override
	public List<Users> findAll() {
		List<Users> listU = dao.findAll();
		return listU;
	}

	@Override
	public Users findByUsername(String username) {
		Users user = dao.findByUsernameLike(username);
		return user;
	}
	
	
	@Override
	public Users findById(Integer id) {
		Users user = dao.getReferenceById(id);
		return user;
	}

	@Override
	public Users save(Users users) {
		Users user = dao.save(users);
		return user;
	}

	@Override
	public void delete(Integer us) {
		dao.deleteById(us);
	}

	@Override
	public Users getUserCookie() {
		return dao.findByUsernameLike(cookieService.getValue("uName"));
	}

	


}
