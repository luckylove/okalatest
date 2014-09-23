package com.marinabay.cruise.service;

import com.marinabay.cruise.dao.GenericDao;
import com.marinabay.cruise.model.GenericModel;

import java.util.List;
import java.util.Map;


public abstract class GenericService<T extends GenericModel>{

	public abstract GenericDao<T> getDao();

	public int deleteByID(long id) {
		return getDao().deleteByID(id);
	}

	public void insert(T record) {
		getDao().insert(record);
	}

	public List<T> select(Map<String, Object> map) {
		return getDao().select(map);
	}

	public T selectByID(long id) {
		return getDao().selectByID(id);
	}
	
	public void update(T record) {
		getDao().update(record);
	}

}
