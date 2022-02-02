package com.lj.novels.interceptor;

import com.lj.novels.daomain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user") ;
        if(user != null){
            return true ;
        }
        request.getRequestDispatcher("/login").forward(request,response);
        return false ;
    }
}
