package com.javawebprogramming.dao;

import java.util.List;

import com.javawebprogramming.mapper.Mapper;

public interface IGenericDAO<T> {

	List<T> query(String sql, Mapper<T> mapper, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);
	int count(String sql);
}
