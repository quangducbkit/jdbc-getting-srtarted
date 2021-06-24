package com.javawebprogramming.dao;

import java.util.List;

import com.javawebprogramming.model.CommentModel;


public interface ICommentDAO {
	void deleteByNews(Long newsId);
	List<CommentModel> findByNews(Long newsId);
	List<CommentModel> findByUser(Long userId);
	Long save(CommentModel commentModel);
	void update(CommentModel commentModel);
	void delete(Long id);
	CommentModel findOne(Long id);
}
