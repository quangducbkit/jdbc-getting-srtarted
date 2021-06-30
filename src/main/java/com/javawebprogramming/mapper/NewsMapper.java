package com.javawebprogramming.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.javawebprogramming.model.NewsModel;

public class NewsMapper implements Mapper<NewsModel> {

	@Override
	public NewsModel rowMapper(ResultSet resultSet) {
		try {
			NewsModel newsModel = new NewsModel();
			newsModel.setId(resultSet.getLong("id"));
			newsModel.setTitle(resultSet.getString("title"));
			newsModel.setContent(resultSet.getString("content"));
			newsModel.setCategoryId(resultSet.getLong("categoryId"));
			newsModel.setThumbnail(resultSet.getString("thumbnail"));
			newsModel.setShortDescription(resultSet.getString("shortdescription"));
			newsModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			newsModel.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				newsModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				newsModel.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return newsModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
