package com.marinabay.cruise.dao;


import com.marinabay.cruise.model.User;

public interface UserDao extends GenericDao<User> {

	public User findUser(String email);

}