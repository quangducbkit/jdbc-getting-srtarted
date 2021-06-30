package com.javawebprogramming.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FormUtil {

	@SuppressWarnings("deprecation")
	public static <T> T toModel(Class<T> classType, HttpServletRequest request)
	{
		T object = null;
		try {
			object = classType.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} 
		return object;
	}
}
