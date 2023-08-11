package com.fpoly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.Entity.Order;
@Repository
public interface OrderDAO extends JpaRepository<Order, Integer>{

	List<Order> findByStatus(Integer status);
}
