package com.javawebprogramming.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.javawebprogramming.model.CategoryModel;

public class CategoryMapper implements Mapper<CategoryModel>{

	@Override
	public CategoryModel rowMapper(ResultSet resultSet) {
		// TODO Auto-generated method stub
		CategoryModel categoryModel = new CategoryModel();
		try {
			categoryModel.setId(resultSet.getLong("id"));
			categoryModel.setCode(resultSet.getString("code"));
			categoryModel.setName(resultSet.getString("name"));
			return categoryModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
