package com.fpoly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.Entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{

}
