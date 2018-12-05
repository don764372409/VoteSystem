package com.yuanmaxinxi.web;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
public class UeditorConfigController {
	@RequestMapping("/config")
	public void config(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("application/json");
		org.springframework.core.io.Resource res = new ClassPathResource("static\\H-ui\\lib\\ueditor\\1.4.3.3\\jsp");
		response.setCharacterEncoding("utf-8");
		try {
			String path = res.getURL().getPath().substring(1);
			String rootPath = new ActionEnter( request, path ).exec();
			PrintWriter out = response.getWriter();
			out.write(rootPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
