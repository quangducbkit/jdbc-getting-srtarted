package com.javawebprogramming.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebprogramming.model.NewsModel;
import com.javawebprogramming.model.UserModel;
import com.javawebprogramming.service.ICategoryService;
import com.javawebprogramming.service.INewsService;
import com.javawebprogramming.service.impl.CategoryService;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6258149374610508335L;

	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewsService newsService;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

}
