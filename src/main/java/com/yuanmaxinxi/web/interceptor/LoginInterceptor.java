package com.yuanmaxinxi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.yuanmaxinxi.domain.admin.Admin;

public class LoginInterceptor implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		Admin loginAdmin = (Admin)request.getSession().getAttribute("loginAdmin");
		if (loginAdmin==null) {
			response.sendRedirect("/login/show");
			return false;
		}
        return true;
    }
}
