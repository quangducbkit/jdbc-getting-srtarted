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
import com.javawebprogramming.paging.PageRequest;
import com.javawebprogramming.service.ICategoryService;
import com.javawebprogramming.service.INewsService;
import com.javawebprogramming.sort.Sorter;
import com.javawebprogramming.utils.FormUtil;
import com.javawebprogramming.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet{

	/**
	 * 
	 */
	
	@Inject
	private INewsService newsService;
	@Inject
	private ICategoryService categoryService;
	
	private static final long serialVersionUID = 1754187861286125337L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		NewsModel model = new FormUtil().toModel(NewsModel.class, req);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST))
		{
			Sorter sorter = new Sorter(model.getSortName(), model.getSortBy());
			PageRequest pageRequest = new PageRequest(model.getPage(), model.getMaxPageItem(),sorter);
			model.setListResult(newsService.findAll(pageRequest));
			model.setTotalPage(newsService.getTotalItem());
			int totalPage = (int) (Math.ceil((double) model.getTotalPage() / model.getMaxPageItem()));
			model.setTotalPage(totalPage);
			view = "/views/admin/news/list.jsp";
		} else if(model.getType().equals(SystemConstant.EDIT))
		{
			if(model.getId() != null)
			{
				model = newsService.findOne(model.getId());
			} else {
				
			}
			req.setAttribute("categories", categoryService.findAll());
			view ="/views/admin/news/edit.jsp";
		}
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

}
