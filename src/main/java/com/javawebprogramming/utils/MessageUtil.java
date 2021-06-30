package com.javawebprogramming.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest req) {
		ResourceBundle rbMessage = ResourceBundle.getBundle("message");
		ResourceBundle rbAlert = ResourceBundle.getBundle("alert");
		if(req.getParameter("message") != null)
		{
			String messageRespone = "";
			String alert = "";
			String message = req.getParameter("message");
			messageRespone = rbMessage.getString(message);
			alert = rbAlert.getString(message);
			req.setAttribute("messageRespone", messageRespone);
			req.setAttribute("alert", alert);
		}
	}
	

}
