package com.keep.service;

import com.keep.dao.UserDao;
import com.keep.domain.User;

/**
 * Created by tcf24 on 2016/4/11.
 */
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(User user){
        user = userDao.find(user);
        return user == null ? null : user;
    }

    public void update(User user){
        userDao.update(user);
    }
    public void save(User user){
        userDao.save(user);
    }

    public void register(User user){
        userDao.save(user);
    }

    public User findUser(User user){
      return  userDao.find(user);
    }
}
