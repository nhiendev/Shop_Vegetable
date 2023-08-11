package com.fpoly.API_User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.DAO.ProductDAO;
import com.fpoly.Entity.Product;
import com.fpoly.HandleService.FileService;
@CrossOrigin("*")
@RestController
public class API_Home {
	
	@Autowired
	FileService FileService;
	
	@Autowired
	ProductDAO dao;
	
	@GetMapping("/api/file/{folder}")
	public List<String> getAll(@PathVariable("folder") String folder) {
		return FileService.list(folder);
	}
	

}
