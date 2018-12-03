package com.yuanmaxinxi.web.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String list(Model model) {
		List<Role> list = roleService.selectAll();
		model.addAttribute("list", list);
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
	public @ResponseBody ResultDTO edit(Role obj) {
		ResultDTO dto;
		try {
			roleService.update(obj);
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
	
}
