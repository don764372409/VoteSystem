package com.yuanmaxinxi.web.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.service.resource.ResourceService;
@Configuration
public class LoginInterceptor implements HandlerInterceptor{
	private ResourceService resourceService;
	public LoginInterceptor(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		String requestURI = request.getRequestURI();
		//获取所有被权限管理的菜单
		List<Resource> res = resourceService.selectAll();
		List<String> resUrls = new ArrayList<>();
		for (Resource re : res) {
			resUrls.add(re.getUrl());
		}
		System.err.println(requestURI);
		if (requestURI.equals("/index/")) {
			//首页需要判断登录
			Admin loginAdmin = (Admin)request.getSession().getAttribute("loginAdmin");
			if (loginAdmin==null) {
				response.sendRedirect("/login/show");
				return false;
			}
			return true;
		}
		//当前请求的URL 没有被权限管理  直接放行
		if (!resUrls.contains(requestURI)) {
			return true;
		}
		System.err.println("拦截");
		//被管理的url同样需要拦截
		Admin loginAdmin = (Admin)request.getSession().getAttribute("loginAdmin");
		if (loginAdmin==null) {
			response.sendRedirect("/login/show");
			return false;
		}
		//如果被管理了
		//获取登录者菜单  不要按钮
		List<Resource> list = resourceService.getAllResourceByAdmin(loginAdmin.getId());
		List<String> urls = new ArrayList<>();
		for (Resource re : list) {
			urls.add(re.getUrl());
		}
		//但是登陆者又没有这个权限
		if (!urls.contains(requestURI)) {
			response.sendRedirect("/login/noRole");
			return false;
		}
		
		
        return true;
    }
}
