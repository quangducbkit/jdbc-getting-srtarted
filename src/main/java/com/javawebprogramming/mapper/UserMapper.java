package com.javawebprogramming.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.javawebprogramming.model.RoleModel;
import com.javawebprogramming.model.UserModel;

public class UserMapper implements Mapper<UserModel> {

	@Override
	public UserModel rowMapper(ResultSet resultSet) {
		try {
			UserModel userModel = new UserModel();
			userModel.setId(resultSet.getLong("id"));
			userModel.setUserName(resultSet.getString("username"));
			userModel.setFullName(resultSet.getString("fullname"));
			userModel.setStatus(resultSet.getInt("status"));
			try {
				RoleModel roleModel = new RoleModel();
				roleModel.setCode(resultSet.getString("code"));
				roleModel.setName(resultSet.getString("name"));
				userModel.setRoleModel(roleModel);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return userModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
