package com.fpoly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.Entity.Order_Detail;
@Repository
public interface Order_DetailDAO extends JpaRepository<com.fpoly.Entity.Order_Detail,Integer>{

	@Query(value = "select * from OrdersDetails where id =  ?1",nativeQuery = true)
	List<Order_Detail> getAllOd(Integer id);
}
