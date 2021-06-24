package com.javawebprogramming.service;

import java.util.List;

import com.javawebprogramming.model.NewsModel;

public interface INewsService {
	List<NewsModel> findByCategory(Long categoryId);
	NewsModel Save(NewsModel newsModel);
	NewsModel Update(NewsModel newsModel);
	void Delete(Long[] ids);
	NewsModel findOne(Long id);
	List<NewsModel> findAll(int offset, int limit);
	int getTotalItem();
}
