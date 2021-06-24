package com.javawebprogramming.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javawebprogramming.model.NewsModel;
import com.javawebprogramming.service.INewsService;
import com.javawebprogramming.utils.HttpUtil;


@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet{

	/**
	 * 
	 */
	@Inject
	private INewsService newsService;
	
	private static final long serialVersionUID = -2926325508922667421L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newsModel = newsService.Save(newsModel);
		mapper.writeValue(res.getOutputStream(), newsModel);

	}
	
	public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newsModel = newsService.Update(newsModel);
		mapper.writeValue(res.getOutputStream(), newsModel);
	}
	
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newsService.Delete(newsModel.getIds());
		mapper.writeValue(res.getOutputStream(), "{}");
	}
}
