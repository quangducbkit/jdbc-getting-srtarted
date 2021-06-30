package com.javawebprogramming.service.impl;

import javax.inject.Inject;

import com.javawebprogramming.dao.IUserDAO;
import com.javawebprogramming.model.UserModel;
import com.javawebprogramming.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDAO;
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer staus) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, staus);
	}

}
