package com.fpoly.Controller_Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fpoly.DAO.CategoryDAO;
import com.fpoly.Entity.Category;
import com.fpoly.Entity.Product;
import com.fpoly.HandleService.MultipleUpload;
import com.fpoly.Service.ProductService;

@Controller
@RequestMapping("/admin")
public class Controller_Product {
	

	@Autowired
	private ProductService productService;
	
	@Autowired
	private MultipleUpload   upload;
	
	@Autowired
	private CategoryDAO daoC;
	
	@ModelAttribute("listCategory")
	public List<Category> list(){
		return daoC.findAll();
	}
	
	@GetMapping("/product")
	public String view(Model model) {
		model.addAttribute("listProduct", productService.findAll());
		return "Admin/tblProduct";
	}
	
	@GetMapping("/product-create")
	public String create(Model model) {
		model.addAttribute("product",new  Product());
		return "Admin/editProduct";
	}
	
	@PostMapping("/product-save")
	public String save(@ModelAttribute("product") Product product,@RequestParam("filename") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		//upload.handleUploadFile(file);
		return "redirect:/admin/product-create";
	}

//	@PostMapping("/product-save")
//	public String save(Model model,@ModelAttribute("product") Product product) {
//		model.addAttribute("product",new  Product());
//		return "Admin/editProduct";
//	}
	
}
