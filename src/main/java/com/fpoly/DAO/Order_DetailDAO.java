package com.fpoly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.Entity.Order_Detail;
@Repository
public interface Order_DetailDAO extends JpaRepository<com.fpoly.Entity.Order_Detail,Integer>{

	@Query( "SELECT od FROM Order_Detail od join od.order o WHERE  o.id =?1")
	List<Order_Detail> getAllOd(Integer id);
	
	
	@Query( "SELECT od FROM Order_Detail od  WHERE  od.order.user.username =?1")
	List<Order_Detail> getOrderDetailByUser(String id);
	
	//Thống kê theo ngày
	
	@Query(value = "select o.id,p.img,p.name,p.price,od.quantity,u.username,o.status,o.createdate \r\n"
			+ "				from OrdersDetails od\r\n"
			+ "				INNER JOIN Orders o ON od.orderId = o.id\r\n"
			+ "				INNER JOIN Users u ON o.usernameid = u.id\r\n"
			+ "				INNER JOIN Products p ON  od.productId = p.id\r\n"
			+ "				 WHERE CONVERT(date, o.createdate) = CONVERT(date, GETDATE())",nativeQuery = true)
	List<Object[]> getStatisticsByDay();
	
	// Thống kê số hàng, tiền bán theo ngày
	@Query(value = "select Sum(OrdersDetails.quantity) AS SoLuongSanPham, SUM(OrdersDetails.price * OrdersDetails.quantity) AS TongTienBanDuoc\r\n"
			+ "			from OrdersDetails\r\n"
			+ "			INNER JOIN Orders ON OrdersDetails.orderId = Orders.id\r\n"
			+ "			WHERE CONVERT(date, Orders.createdate) = CONVERT(date, GETDATE())",nativeQuery = true)
	List<Object> getStatisticsOrderAndTotalByDay();
}
