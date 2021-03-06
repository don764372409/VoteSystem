package com.yuanmaxinxi.web.role;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.domain.role.Role;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.resource.ResourceService;
import com.yuanmaxinxi.service.role.RoleService;
@RequestMapping("/role")
@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;
	@RequestMapping("/list")
	public String list(Model model,HttpSession session) {
		List<Role> list = roleService.selectAll();
		model.addAttribute("list", list);
		Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/role/list",loginAdmin.getId());
		List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/role/list",loginAdmin.getId());
		model.addAttribute("btn1s", btn1s);
		model.addAttribute("btn2s", btn2s);
		return "role/list";
	}
	@RequestMapping("/showAdd")
	public String showAdd(Model model) {
		List<Role> list = roleService.selectAll();
		model.addAttribute("list", list);
		return "role/add";
	}
	@RequestMapping("/add")
	public @ResponseBody ResultDTO add(Role obj,@RequestParam(value="ids[]")Long[] ids) {
		ResultDTO dto;
		try {
			roleService.insert(obj,ids);
			dto = ResultDTO.getIntance(true, "机构添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/showEdit")
	public String showEdit(Long id,Model model) {
		Role obj = roleService.selectOneById(id);
		model.addAttribute("obj", obj);
		List<Role> list = roleService.selectAll();
		model.addAttribute("list", list);
		return "role/edit";
	}
	@RequestMapping("/edit")
	public @ResponseBody ResultDTO edit(Role obj,@RequestParam(value="ids[]")Long[] ids) {
		ResultDTO dto;
		try {
			roleService.update(obj,ids);
			dto = ResultDTO.getIntance(true, "机构修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/delete")
	public @ResponseBody ResultDTO delete(Long id) {
		ResultDTO dto;
		try {
			roleService.delete(id);
			dto = ResultDTO.getIntance(true, "角色删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/getAllResource")
	public @ResponseBody List<Resource> getAllResources() {
		return resourceService.getAllResources();
	}
	@RequestMapping("/getAllResourceByRole")
	public @ResponseBody List<Long> getAllResourceByRole(Long roleId) {
		return resourceService.getAllResourceByRole(roleId);
	}
	
}
