package com.marinabay.cruise.service;

import com.marinabay.cruise.dao.UserDao;
import com.marinabay.cruise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: son.nguyen
 * Date: 9/23/14
 * Time: 7:15 PM
 */
@Service
public class UserService extends GenericService<User>{

    @Autowired
    private UserDao userDao;

    @Override
    public UserDao getDao() {
        return userDao;
    }

    public User findUserByEmail(String email) {
        return getDao().findUserByEmail(email);
    }

}
