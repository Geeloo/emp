package net.northking.king.utils;

import java.lang.reflect.ParameterizedType;

public class GenericSuperClass {

	@SuppressWarnings("unchecked")
	
	public static Class getGenericSuperclass(Class entity) {
		ParameterizedType parameterizedType = (ParameterizedType) entity.getGenericSuperclass();
		Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
		return entityClass;
	}

}
