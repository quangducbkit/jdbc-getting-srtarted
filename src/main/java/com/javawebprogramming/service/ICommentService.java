package com.javawebprogramming.service;

import java.util.List;

import com.javawebprogramming.model.CommentModel;

public interface ICommentService {
	void deleteByNews(Long newsId);
	List<CommentModel> findByNews(Long newsId);
	List<CommentModel> findByUser(Long userId);
	CommentModel save(CommentModel commentModel);
	CommentModel update(CommentModel commentModel);
	void delete(Long[] ids);
	CommentModel findOne(Long id);
}
