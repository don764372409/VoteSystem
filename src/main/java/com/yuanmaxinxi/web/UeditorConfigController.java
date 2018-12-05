package com.yuanmaxinxi.web;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
public class UeditorConfigController {
	@Value("${file.uploadFolder}")
    private String uploadFolder;
	@RequestMapping("/config")
	public void config(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		try {
			String rootPath = new ActionEnter( request, uploadFolder ).exec();
			PrintWriter out = response.getWriter();
			out.write(rootPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
