package com.fpoly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.Entity.Users;

@Repository
public interface  UserDAO extends JpaRepository<Users, Integer> {

	Users findByUsernameLike(String username); 
	
	Users findByUsernameLikeAndPasswordLike(String username,String password); 
	
	List<Users> findByUsername(String username);
}
