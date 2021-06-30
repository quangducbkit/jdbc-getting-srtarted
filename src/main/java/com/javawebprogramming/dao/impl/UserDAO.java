package com.javawebprogramming.dao.impl;

import java.util.List;

import com.javawebprogramming.dao.IUserDAO;
import com.javawebprogramming.mapper.UserMapper;
import com.javawebprogramming.model.UserModel;

public class UserDAO extends AbstractDAO implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role as r ON r.id = u.roleid");
		sql.append(" WHERE username =? AND password =? AND status =?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password,status);	
		return users.isEmpty() ? null : users.get(0);
	}

}
