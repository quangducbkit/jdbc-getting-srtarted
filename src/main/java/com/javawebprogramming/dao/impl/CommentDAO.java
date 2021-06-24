package com.javawebprogramming.dao.impl;

import java.util.List;

import com.javawebprogramming.dao.ICommentDAO;
import com.javawebprogramming.mapper.CommentMapper;
import com.javawebprogramming.model.CommentModel;

public class CommentDAO extends AbstractDAO implements ICommentDAO {

	@Override
	public void deleteByNews(Long newsId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM comment WHERE news_id=?";
		update(sql, newsId);
	}

	@Override
	public List<CommentModel> findByNews(Long newsId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM comment WHERE news_id=?";
		List<CommentModel> models = query(sql, new CommentMapper(), newsId);
		return models;
	}

	@Override
	public List<CommentModel> findByUser(Long userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM comment WHERE user_id=?";
		List<CommentModel> models = query(sql, new CommentMapper(), userId);
		return models;
	}

	@Override
	public Long save(CommentModel commentModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO comment (content,");
		sql.append("user_id,news_id,createddate,createdby)");
		sql.append(" values(?,?,?,?,?)");
		return insert(sql.toString(), commentModel.getContent(), commentModel.getUserId(), commentModel.getNewsId(),
				commentModel.getCreatedDate(), commentModel.getCreatedBy());
	}

	@Override
	public void update(CommentModel commentModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE comment SET content =?,");
		sql.append("user_id=?,news_id=?,createddate=?,createdby=?,");
		sql.append("modifieddate=?,modifiedby=?");
		update(sql.toString(), commentModel.getContent(), commentModel.getUserId(), commentModel.getNewsId(),
				commentModel.getCreatedDate(), commentModel.getCreatedBy(), commentModel.getModifiedDate(),
				commentModel.getModifiedBy());

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM comment WHERE id=?";
		update(sql, id);

	}

	@Override
	public CommentModel findOne(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FORM comment where id=?";
		List<CommentModel> models = query(sql, new CommentMapper(), id);
		return models.isEmpty() ? null : models.get(0);
	}

}
