package com.fpoly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.Entity.Category;
import com.fpoly.Entity.Product;
@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{
	
	
	List<Product> findByName(String name);
	
	List<Product> findByCategoryId(Category  categoryId);

	@Query(value = " SELECT Products.id, Products.name, Products.img, Products.price, COUNT(OrdersDetails.productID) AS total_ordered\r\n"
			+ "			 	FROM Orders\r\n"
			+ "				JOIN OrdersDetails ON Orders.id = OrdersDetails.orderID\r\n"
			+ "			 	JOIN Products ON OrdersDetails.productID = Products.id\r\n"
			+ "				GROUP BY Products.id, Products.name, Products.img, Products.price\r\n"
			+ "			 	ORDER BY total_ordered DESC;",nativeQuery = true)
	List<Object> findAllBestSeler();	
	
	@Query(" SELECT p FROM Product p   where p.quantity > 0")
	List<Product> findAllBestInventory();
}
