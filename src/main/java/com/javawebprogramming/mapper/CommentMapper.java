package com.javawebprogramming.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.javawebprogramming.model.CommentModel;
import com.javawebprogramming.model.NewsModel;

public class CommentMapper implements Mapper<CommentModel>{

	@Override
	public CommentModel rowMapper(ResultSet resultSet) {
		// TODO Auto-generated method stub
		try {
			CommentModel model = new CommentModel();
			model.setId(resultSet.getLong("id"));
			model.setContent(resultSet.getString("content"));
			model.setUserId(resultSet.getLong("user_id"));
			model.setNewsId(resultSet.getLong("news_id"));
			model.setCreatedDate(resultSet.getTimestamp("createddate"));
			model.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				model.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				model.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return model;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
