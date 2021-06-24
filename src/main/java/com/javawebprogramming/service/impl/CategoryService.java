package com.javawebprogramming.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.javawebprogramming.dao.ICategoryDAO;
import com.javawebprogramming.dao.impl.CategoryDAO;
import com.javawebprogramming.model.CategoryModel;
import com.javawebprogramming.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Inject
	private ICategoryDAO categoryDao;
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}
	@Override
	public CategoryModel findOneByCode(String code) {
		// TODO Auto-generated method stub
		return categoryDao.findOneByCode(code);
	}

}
