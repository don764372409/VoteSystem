package com.yuanmaxinxi.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.admin.AdminService;

@RequestMapping("/my")
@Controller
public class MyController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/index")
	public String index(HttpSession session,Model model) {
		Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
		Admin obj = adminService.selectOneById(loginAdmin.getId());
		model.addAttribute("obj", obj);
		return "my/index";
	}
	@RequestMapping("/editPassword")
	public @ResponseBody ResultDTO editPassword(Admin obj,String confPassword,HttpSession session) {
		ResultDTO dto;
		try {
			Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
			loginAdmin = adminService.editPassword(loginAdmin,obj,confPassword);
			session.setAttribute("loginAdmin", loginAdmin);
			dto = ResultDTO.getIntance(true, "密码修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
}
