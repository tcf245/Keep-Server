package com.keep.dao;

import com.keep.domain.User;
import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tcf24 on 2016/4/11.
 */
@Transactional
public class UserDao {
    private HibernateTemplate template;

    public UserDao(HibernateTemplate template) {
        this.template = template;
    }

    public void save(User user){
        template.save(user);
    }

    public void update(User user){
        template.update(user);
    }

    public User find(User user){
        user = (User) template.find("from User where username = ? and password = ?",user.getUsername(),user.getPassword());
        return user;
    }
}
