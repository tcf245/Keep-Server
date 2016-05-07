package com.keep.dao;

import com.keep.domain.User;
import org.apache.commons.lang3.StringUtils;
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
        String hql = " from  User where 1=1 ";
        StringBuilder sb = new StringBuilder(hql);

        if(StringUtils.isNotBlank(user.getUsername())){
            sb.append(" username = '").append(user.getUsername()).append("'");
        }
        if(StringUtils.isNotBlank(user.getPassword())){
            sb.append(" password = '").append(user.getPassword()).append("'");
        }

        if(StringUtils.isNotBlank(user.getToken())){
            sb.append(" password = '").append(user.getToken()).append("'");
        }
        user = (User) template.find(sb.toString());
        return user;
    }

}
