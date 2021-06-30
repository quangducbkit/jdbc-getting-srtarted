package com.javawebprogramming.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebprogramming.constant.SystemConstant;
import com.javawebprogramming.model.UserModel;
import com.javawebprogramming.utils.SessionUtil;

public class AuthorizationFilter implements Filter{

	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getRequestURI();	
		if(url.startsWith("/admin")) {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			if(model != null) {
				System.out.println(model.getRoleModel().getCode());
				if(model.getRoleModel().getCode().equals(SystemConstant.ADMIN))
				{
					chain.doFilter(request, response);
				} else if(model.getRoleModel().getCode().equals(SystemConstant.USER)){
					response.sendRedirect(request.getContextPath() + "/login?action=login&message=not_permission&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/login?action=login&message=not_login&alert=danger");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}

}
