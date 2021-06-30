package com.javawebprogramming.service.impl;


import java.io.Console;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.javawebprogramming.dao.ICategoryDAO;
import com.javawebprogramming.dao.ICommentDAO;
import com.javawebprogramming.dao.INewsDAO;
import com.javawebprogramming.model.CategoryModel;
import com.javawebprogramming.model.NewsModel;
import com.javawebprogramming.paging.IPageble;
import com.javawebprogramming.service.INewsService;

public class NewsService implements INewsService{

	@Inject
	private INewsDAO newsDao;
	
	@Inject
	private ICategoryDAO categoryDao;
	
	@Inject
	private ICommentDAO commentDao;
	
	@Override
	public List<NewsModel> findByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return newsDao.findByCategory(categoryId);
	}

	@Override
	public NewsModel Save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDao.findOneByCode(newsModel.getCategoryCode());
		newsModel.setCategoryId(categoryModel.getId());
		Long newsId = newsDao.save(newsModel);
		return newsDao.findOne(newsId);
	}

	@Override
	public NewsModel Update(NewsModel newsModel) {
		// TODO Auto-generated method stub
		NewsModel oldNews = newsDao.findOne(newsModel.getId());
		newsModel.setCreatedBy(oldNews.getCreatedBy());
		newsModel.setCreatedDate(oldNews.getCreatedDate());
		newsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDao.findOneByCode(newsModel.getCategoryCode());
		newsModel.setCategoryId(categoryModel.getId());
		newsDao.update(newsModel);
		return newsDao.findOne(newsModel.getId());
		
	}

	@Override
	public void Delete(Long[] ids) {
		// TODO Auto-generated method stub
		for (Long id : ids) {
			commentDao.deleteByNews(id);
			newsDao.delete(id);
		}
	}

	@Override
	public NewsModel findOne(Long id) {
		NewsModel newsModel = newsDao.findOne(id);
		System.out.println(newsModel.getCategoryId());
		System.out.println(newsModel.getCategoryId());
		CategoryModel categoryModel = categoryDao.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}

	@Override
	public List<NewsModel> findAll(IPageble pageble) {
		return newsDao.findAll(pageble);
		
	}

	@Override
	public int getTotalItem() {
		return newsDao.getTotalItem();
	}
}
