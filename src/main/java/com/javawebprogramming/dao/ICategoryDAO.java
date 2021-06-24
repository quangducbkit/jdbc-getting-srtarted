package com.javawebprogramming.dao;

import java.util.List;

import com.javawebprogramming.model.CategoryModel;

public interface ICategoryDAO {

	List<CategoryModel> findAll();
	CategoryModel findOneByCode(String code);
	CategoryModel findOne(Long id);
}
