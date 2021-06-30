package com.javawebprogramming.dao.impl;

import java.util.List;

import com.javawebprogramming.dao.INewsDAO;
import com.javawebprogramming.mapper.NewsMapper;
import com.javawebprogramming.model.NewsModel;
import com.javawebprogramming.paging.IPageble;

public class NewsDAO extends AbstractDAO implements INewsDAO {

	@Override
	public List<NewsModel> findByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM news WHERE categoryid =?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(),
				newsModel.getShortDescription(), newsModel.getCategoryId(), newsModel.getCreatedDate(),
				newsModel.getCreatedBy());
	}

	@Override
	public void update(NewsModel newsModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), newsModel.getTitle(), newsModel.getThumbnail(), newsModel.getShortDescription(),
				newsModel.getContent(), newsModel.getCategoryId(), newsModel.getCreatedDate(), newsModel.getCreatedBy(),
				newsModel.getModifiedDate(), newsModel.getModifiedBy(), newsModel.getId());

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM news where id =?";
		update(sql, id);
	}

	@Override
	public NewsModel findOne(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM news WHERE id=?";
		List<NewsModel> newsModels = query(sql, new NewsMapper(), id);
		return newsModels.isEmpty() ? null : newsModels.get(0);
	}

	@Override
	public List<NewsModel> findAll(IPageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if (pageble.getSorter() != null && pageble.getSorter().getSortName() != null
				&& pageble.getSorter().getSortBy() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + "," + pageble.getLimit());
		}
		System.out.println(sql.toString());
		List<NewsModel> newsModels = query(sql.toString(), new NewsMapper());
		return newsModels;
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM news";
		return count(sql);
	}

}
