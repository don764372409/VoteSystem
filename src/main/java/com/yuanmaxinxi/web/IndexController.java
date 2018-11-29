package com.yuanmaxinxi.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.service.resource.ResourceService;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private ResourceService resourceService;
	@RequestMapping("/")
	public String index(Model model,HttpSession session) {
		Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
		//获取登录者菜单  不要按钮
		List<Resource> list = (List<Resource>)resourceService.selectAllResourceByType(loginAdmin.getId());
		model.addAttribute("list", list);
		return "index";
	}
}
