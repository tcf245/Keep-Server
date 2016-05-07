package com.keep.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tcf24 on 2016/5/7.
 */
public class TokenCheckInterceptor  extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String token = request.getParameter("token");

        if(StringUtils.isEmpty(token) || StringUtils.isBlank(token)){
            String path = request.getContextPath();
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

            System.out.print("basepath " + basePath );
            response.sendRedirect(basePath+"noToke");
            return false;
        }else{
            return true;
        }
    }
}
