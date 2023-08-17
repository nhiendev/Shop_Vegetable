package com.fpoly.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpoly.DAO.OrderDAO;
import com.fpoly.DAO.Order_DetailDAO;
import com.fpoly.DAO.ProductDAO;
import com.fpoly.Entity.Order;
import com.fpoly.Entity.OrderDetailDTO;
import com.fpoly.Entity.Order_Detail;
import com.fpoly.Entity.Product;

@Service
public class OrderService {

	@Autowired
	OrderDAO dao;

	@Autowired 
	UserService userService;
	
	@Autowired 
	ProductDAO Pdao;
	
	@Autowired
	Order_DetailDAO ODdao;
	
	public Order create(JsonNode nodeData) {
		ObjectMapper mapper = new ObjectMapper();
		  
		Order order = mapper.convertValue(nodeData, Order.class);
		order.setUser(userService.getUserCookie());
		order.setStatus(0); // 0 = order ---  1  = admin xác nhận đơn hàng
		
		dao.save(order);
		System.out.println(order.getId());
		TypeReference<List<OrderDetailDTO>> type  = new TypeReference<List<OrderDetailDTO>>() {
		};
		
		List<OrderDetailDTO> details = mapper.convertValue(nodeData.get("orderdetails"), type);
		
		for (OrderDetailDTO orderDetailDTO : details) {
			Order_Detail order_Detail = new Order_Detail();
			Product pro  = Pdao.getReferenceById(orderDetailDTO.getProduct());
			order_Detail.setOrder(order);
			order_Detail.setPrice(orderDetailDTO.getPrice());
			order_Detail.setProduct(pro);
			order_Detail.setQuantity(orderDetailDTO.getQuantity());
			
			pro.setQuantity(pro.getQuantity() - order_Detail.getQuantity());
			Pdao.save(pro);
			
			ODdao.save(order_Detail);
		}
		

		return order; 
	}

}
