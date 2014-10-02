package com.marinabay.cruise.dao;


import com.marinabay.cruise.model.ActiveUser;

import java.util.Map;

public interface ActiveUserDao extends GenericDao<ActiveUser> {

    public void increase(Long id) ;

    public ActiveUser selectByDate(Map<String, Object> map);


}