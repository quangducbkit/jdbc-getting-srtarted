package com.javawebprogramming.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.javawebprogramming.dao.IGenericDAO;
import com.javawebprogramming.mapper.Mapper;

public class AbstractDAO<T> implements IGenericDAO<T>{

	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	public Connection getConnection()
	{
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			return null;
		}
	}
	
	@Override
	public List<T> query(String sql, Mapper<T> mapper, Object... parameters) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		PreparedStatement statement = null;
		List<T> resultQuery = new ArrayList<T>();
		ResultSet resultSet = null;
		if(connection != null)
		{
			try {
				connection.setAutoCommit(false);
				statement = connection.prepareStatement(sql);
				for(int i = 0; i < parameters.length; i ++)
				{
					statement.setObject(i + 1, parameters[i]);
				}
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					resultQuery.add(mapper.rowMapper(resultSet));
				}
				return resultQuery;
				
			} catch (SQLException e) {
				// TODO: handle exception
			} finally {
				try {
					if (connection != null)
						connection.close();
					if (statement != null)
						statement.close();
					if (resultSet != null)
						resultSet.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public Long insert(String sql, Object...parameters) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Long id = null;
		if(connection != null)
		{
			try {
				connection.setAutoCommit(false);
				preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				for(int i = 0; i < parameters.length; i ++)
				{
					preparedStatement.setObject(i + 1, parameters[i]);
				}
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next())
				{
					id = resultSet.getLong(1);
				}
				connection.commit();
				return id;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if(connection != null)
				{
					try {
						connection.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				return null;
			} finally {
				try {
					if (connection != null)
						connection.close();
					if (preparedStatement != null)
						preparedStatement.close();
					if (resultSet != null)
						resultSet.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		if(connection != null)
		{
			try {
				connection.setAutoCommit(false);
				preparedStatement = connection.prepareStatement(sql);
				for(int i = 0; i < parameters.length; i ++)
				{
					preparedStatement.setObject(i + 1, parameters[i]);
				}
				preparedStatement.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if(connection != null)
				{
					try {
						connection.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} finally {
				try {
					if (connection != null)
						connection.close();
					if (preparedStatement != null)
						preparedStatement.close();
				} catch (SQLException e2) {
				}
			}
		}
	}

	@Override
	public int count(String sql) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		if(connection != null)
		{
			try {
				
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					count = resultSet.getInt(1);
				}
				return count;
				
			} catch (SQLException e) {
				// TODO: handle exception
			} finally {
				try {
					if (connection != null)
						connection.close();
					if (statement != null)
						statement.close();
					if (resultSet != null)
						resultSet.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					return 0;
				}
			}
			
			
		}
		return 0;
	}

}
