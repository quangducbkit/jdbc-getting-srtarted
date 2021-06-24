package com.javawebprogramming.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebprogramming.constant.SystemConstant;
import com.javawebprogramming.model.NewsModel;
import com.javawebprogramming.service.INewsService;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet{

	/**
	 * 
	 */
	
	@Inject
	private INewsService newsService;
	private static final long serialVersionUID = 1754187861286125337L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		NewsModel model = new NewsModel();
		String pageStr = req.getParameter("page");
		String maxPageItemStr = req.getParameter("maxPageItem");
		if(pageStr != null)
		{
			model.setPage(Integer.parseInt(pageStr));
		} else {
			model.setPage(1);
		}
		
		if(maxPageItemStr != null)
		{
			model.setMaxPageItem(Integer.parseInt(maxPageItemStr));
		} 
		int offset = (model.getPage() - 1) * model.getMaxPageItem();
		
		
		model.setListResult(newsService.findAll(offset,model.getMaxPageItem()));
		int totalPage = (int) (Math.ceil((double) model.getListResult().size() / model.getMaxPageItem()));
		model.setTotalPage(totalPage);
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/news/list.jsp");
		rd.forward(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

}
