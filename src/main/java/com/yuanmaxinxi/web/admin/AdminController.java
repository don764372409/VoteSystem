package com.yuanmaxinxi.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.service.admin.AdminService;
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Admin> list = adminService.selectAll();
		model.addAttribute("list", list);
		return "admin/list";
	}
}
