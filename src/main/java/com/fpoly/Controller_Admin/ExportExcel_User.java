package com.fpoly.Controller_Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpoly.Entity.Users;
import com.fpoly.Service.UserService;

@Controller
public class ExportExcel_User {

	@Autowired
	UserService service;
	@ResponseBody
	@GetMapping("/export/user")
	public String exportExcel(  HttpServletResponse response) throws IOException {

		
		
		// Tạo một workbook mới (Excel workbook)
		Workbook workbook = new XSSFWorkbook();

		// Tạo một trang tính mới (Excel sheet)
		Sheet sheet = workbook.createSheet("Danh sách User");

		// Tạo dòng tiêu đề
		Row headerRow = sheet.createRow(0);
		List<Users> columns = service.findAll();

		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("UserName");
		headerRow.createCell(2).setCellValue("Password");
		headerRow.createCell(3).setCellValue("FullName");
		headerRow.createCell(4).setCellValue("Phone");
		headerRow.createCell(5).setCellValue("Email");
	

		// Thêm dữ liệu mẫu
		int rowNum = 1;
		for (Users rowData : columns) {
			Row row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(rowData.getId());
			row.createCell(1).setCellValue(rowData.getUsername());
			row.createCell(2).setCellValue(rowData.getPassword());
			row.createCell(3).setCellValue(rowData.getFullname());
			row.createCell(4).setCellValue(rowData.getPhone());
			row.createCell(5).setCellValue(rowData.getEmail());
			rowNum++;
		}
		
		

		// Thiết lập các thông tin HTTP header cho tệp Excel
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename="+ Users.class.getSimpleName() + ".xlsx");

		// Ghi workbook ra OutputStream của HttpServletResponse
		workbook.write(response.getOutputStream());

		// Đóng workbook
		workbook.close();

		return "redirect:/admin/user";
	}

}
