package com.yuanmaxinxi.web.organize;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.organize.OrganizeService;
import com.yuanmaxinxi.service.resource.ResourceService;
@RequestMapping("/organize")
@Controller
public class OrganizeController {
	@Autowired
	private OrganizeService organizeService;
	@Autowired
	private ResourceService resourceService;
	@RequestMapping("/list")
	public String list(Model model,HttpSession session) {
		List<Organize> list = organizeService.selectAll();
		model.addAttribute("list", list);
		Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/organize/list",loginAdmin.getId());
		List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/organize/list",loginAdmin.getId());
		model.addAttribute("btn1s", btn1s);
		model.addAttribute("btn2s", btn2s);
		return "organize/list";
	}
	@RequestMapping("/showAdd")
	public String showAdd(Model model) {
		List<Organize> list = organizeService.selectAll();
		model.addAttribute("list", list);
		return "organize/add";
	}
	@RequestMapping("/add")
	public @ResponseBody ResultDTO add(Organize obj) {
		ResultDTO dto;
		try {
			organizeService.insert(obj);
			dto = ResultDTO.getIntance(true, "机构添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/showEdit")
	public String showEdit(Long id,Model model) {
		Organize obj = organizeService.selectOneById(id);
		model.addAttribute("obj", obj);
		List<Organize> list = organizeService.selectAll();
		model.addAttribute("list", list);
		return "organize/edit";
	}
	@RequestMapping("/edit")
	public @ResponseBody ResultDTO edit(Organize obj) {
		ResultDTO dto;
		try {
			organizeService.update(obj);
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
			organizeService.delete(id);
			dto = ResultDTO.getIntance(true, "机构删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
}
