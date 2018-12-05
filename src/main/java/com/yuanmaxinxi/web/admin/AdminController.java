package com.yuanmaxinxi.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.domain.role.Role;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.admin.AdminService;
import com.yuanmaxinxi.service.organize.OrganizeService;
import com.yuanmaxinxi.service.role.RoleService;
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private OrganizeService organizeService;
	@Autowired
	private RoleService roleService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Admin> list = adminService.selectAll();
		model.addAttribute("list", list);
		return "admin/list";
	}
	@RequestMapping("/showAdd")
	public String showAdd(Model model) {
		List<Role> list = roleService.selectAll();
		model.addAttribute("list", list);
		return "admin/add";
	}
	@RequestMapping("/showOrg")
	public String showOrg(Model model) {
		List<Organize> list = organizeService.selectOrgAndeDeptToTree();
		model.addAttribute("list", list);
		System.err.println(list);
		return "admin/organize";
	}
	@RequestMapping("/add")
	public @ResponseBody ResultDTO add(Admin obj,Long roleId) {
		ResultDTO dto;
		try {
			adminService.insert(obj,roleId);
			dto = ResultDTO.getIntance(true, "管理员添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/edit")
	public @ResponseBody ResultDTO edit(Admin obj,Long roleId) {
		ResultDTO dto;
		try {
			adminService.update(obj,roleId);
			dto = ResultDTO.getIntance(true, "管理员添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/showEdit")
	public String showEdit(Model model,Long id) {
		Admin obj = adminService.selectOneById(id);
		model.addAttribute("obj", obj);
		List<Role> list = roleService.selectAll();
		model.addAttribute("list", list);
		return "admin/edit";
	}
	@RequestMapping("/delete")
	public @ResponseBody ResultDTO delete(Long id) {
		ResultDTO dto;
		try {
			adminService.delete(id);
			dto = ResultDTO.getIntance(true, "管理员删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/resetPassword")
	public @ResponseBody ResultDTO resetPassword(Long id) {
		ResultDTO dto;
		try {
			adminService.resetPassword(id);
			dto = ResultDTO.getIntance(true, "管理员密码重置成功,新密码为:88888888(8个8)!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
}
