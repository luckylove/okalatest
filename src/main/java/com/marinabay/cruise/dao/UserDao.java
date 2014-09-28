package com.marinabay.cruise.dao;


import com.marinabay.cruise.model.User;

import java.util.Map;

public interface UserDao extends GenericDao<User> {

	public User findUserByEmail(String email);

    public void assignGroup(Map<String, Object> map) ;

}