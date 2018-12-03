package com.yuanmaxinxi.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.service.admin.AdminService;
import com.yuanmaxinxi.service.organize.OrganizeService;
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private OrganizeService organizeService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Admin> list = adminService.selectAll();
		model.addAttribute("list", list);
		return "admin/list";
	}
	@RequestMapping("/showAdd")
	public String showAdd() {
		return "admin/add";
	}
	@RequestMapping("/showOrg")
	public String showOrg(Model model) {
		List<Organize> list = organizeService.selectOrgAndeDeptToTree();
		model.addAttribute("list", list);
		System.err.println(list);
		return "admin/organize";
	}
	
}
