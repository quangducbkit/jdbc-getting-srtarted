package com.javawebprogramming.dao;

import com.javawebprogramming.model.UserModel;

public interface IUserDAO {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer staus);

}
