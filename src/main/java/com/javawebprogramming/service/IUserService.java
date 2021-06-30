package com.javawebprogramming.service;

import java.util.List;

import com.javawebprogramming.model.NewsModel;
import com.javawebprogramming.model.UserModel;
import com.javawebprogramming.paging.IPageble;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer staus);
}
