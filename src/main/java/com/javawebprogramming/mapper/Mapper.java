package com.javawebprogramming.mapper;

import java.sql.ResultSet;

public interface Mapper<T> {
	T rowMapper(ResultSet resultSet);
}
