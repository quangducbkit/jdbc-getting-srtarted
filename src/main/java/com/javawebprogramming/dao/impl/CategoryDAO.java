package com.javawebprogramming.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javawebprogramming.dao.ICategoryDAO;
import com.javawebprogramming.mapper.CategoryMapper;
import com.javawebprogramming.model.CategoryModel;

public class CategoryDAO extends AbstractDAO implements ICategoryDAO {


	@Override
	public List<CategoryModel> findAll() {
		
		List<CategoryModel> results = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM CATEGORY";
		 return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM category WHERE code =?";
		List<CategoryModel> categoryModels = query(sql, new CategoryMapper(), code);
		return categoryModels.isEmpty()?null:categoryModels.get(0);
	}

	@Override
	public CategoryModel findOne(Long id) {
		String sql = "SELECT * FROM category WHERE id =?";
		List<CategoryModel> categoryModels = query(sql, new CategoryMapper(), id);
		return categoryModels.isEmpty()?null:categoryModels.get(0);
	}
	
}
