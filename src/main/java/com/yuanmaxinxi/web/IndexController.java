package com.yuanmaxinxi.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.domain.role.Role;
import com.yuanmaxinxi.service.admin.AdminService;
import com.yuanmaxinxi.service.dept.DeptService;
import com.yuanmaxinxi.service.resource.ResourceService;
import com.yuanmaxinxi.service.role.RoleService;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private AdminService adminService;
	@RequestMapping("/")
	public String index(Model model,HttpSession session) {
		Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
		//获取登录者菜单  不要按钮
		List<Resource> list = resourceService.selectAllResourceByType(loginAdmin.getId());
		model.addAttribute("list", list);
		List<Role> roles = roleService.selectAllByAdminId(loginAdmin.getId());
		model.addAttribute("roles", roles);
		Admin admin = adminService.selectOneById(loginAdmin.getId());
		model.addAttribute("admin", admin);
		return "index";
	}
}
