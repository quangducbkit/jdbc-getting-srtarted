package com.javawebprogramming.dao;

import java.util.List;

import com.javawebprogramming.model.NewsModel;

public interface INewsDAO {
	List<NewsModel> findByCategory(Long categoryId);
	Long save(NewsModel newsModel);
	void update(NewsModel newsModel);
	void delete(Long id);
	NewsModel findOne(Long id);
	List<NewsModel> findAll(int offset, int limit);
	int getTotalItem();
}
