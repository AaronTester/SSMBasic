package com.aaron.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/6
 */
public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        if(request.getRequestURI().contains("login")) {
            return true;
        }
        if(request.getSession().getAttribute("USER_INFO") != null) {
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/page/index.jsp").forward(request ,response);
        return false;
    }
}
