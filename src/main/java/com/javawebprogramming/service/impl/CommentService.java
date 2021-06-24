package com.javawebprogramming.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.javawebprogramming.dao.ICommentDAO;
import com.javawebprogramming.model.CommentModel;
import com.javawebprogramming.service.ICommentService;

public class CommentService implements ICommentService{

	@Inject
	ICommentDAO commentDAO;
	@Override
	public void deleteByNews(Long newsId) {
		// TODO Auto-generated method stub
		commentDAO.deleteByNews(newsId);
		
	}

	@Override
	public List<CommentModel> findByNews(Long newsId) {
		// TODO Auto-generated method stub
		return commentDAO.findByNews(newsId);
	}

	@Override
	public List<CommentModel> findByUser(Long userId) {
		// TODO Auto-generated method stub
		return commentDAO.findByUser(userId);
	}

	@Override
	public CommentModel save(CommentModel commentModel) {
		// TODO Auto-generated method stub
		Long id = commentDAO.save(commentModel);
		return commentDAO.findOne(id);
	}

	@Override
	public CommentModel update(CommentModel commentModel) {
		// TODO Auto-generated method stub
		Long id = commentModel.getId();
		CommentModel oldComment = commentDAO.findOne(id);
		commentModel.setCreatedBy(oldComment.getCreatedBy());
		commentModel.setCreatedDate(oldComment.getCreatedDate());
		commentModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		commentDAO.update(commentModel);
		return commentDAO.findOne(id);
	}

	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub
		for (Long id : ids) {
			commentDAO.delete(id);
		}
		
	}

	@Override
	public CommentModel findOne(Long id) {
		// TODO Auto-generated method stub
		return commentDAO.findOne(id);
	}

}
