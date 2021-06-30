package com.javawebprogramming.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebprogramming.model.UserModel;
import com.javawebprogramming.service.ICategoryService;
import com.javawebprogramming.service.INewsService;
import com.javawebprogramming.service.IUserService;
import com.javawebprogramming.utils.FormUtil;
import com.javawebprogramming.utils.MessageUtil;
import com.javawebprogramming.utils.SessionUtil;

@WebServlet(urlPatterns = { "/home", "/login", "/logout" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6258149374610508335L;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewsService newsService;

	@Inject
	private IUserService userService;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			MessageUtil.showMessage(req);
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, res);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			res.sendRedirect(req.getContextPath() + "/home");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, res);
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel userModel = FormUtil.toModel(UserModel.class, req);
			userModel = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(),
					1);
			if (userModel != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
				if (userModel.getRoleModel().getCode().equals("USER")) {
					res.sendRedirect(req.getContextPath() + "/home");
				} else if (userModel.getRoleModel().getCode().equals("ADMIN")) {
					res.sendRedirect(req.getContextPath() + "/admin-home");
				}
			} else {
				res.sendRedirect(req.getContextPath() + "/login?action=login&message=username_password_invalid");
			}
		}

	}

}
