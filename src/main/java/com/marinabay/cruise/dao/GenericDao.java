package com.marinabay.cruise.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao<T> {
	
	public int deleteByID(Long id);
	
	public void insert(T record);
	
	public List<T> select(Map<String, Object> map);
	
	public T selectByID(long id);
	
	public int update(T record);
	
	
}
