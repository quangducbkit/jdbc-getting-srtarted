package com.javawebprogramming.service;

import java.util.List;

import com.javawebprogramming.model.CategoryModel;

public interface ICategoryService {

	List<CategoryModel> findAll();
	CategoryModel findOneByCode(String code);
}
