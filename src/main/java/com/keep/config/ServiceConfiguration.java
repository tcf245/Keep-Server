package com.keep.config;

import com.keep.dao.UserDao;
import com.keep.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pc9507 on 2015/12/11.
 */
@Configuration
public class ServiceConfiguration {

    @Bean

    public UserService userService(UserDao userDao){
        return new UserService(userDao);
    }

}
