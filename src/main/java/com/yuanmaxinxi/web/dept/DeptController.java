package com.yuanmaxinxi.web.dept;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.dept.DeptService;
import com.yuanmaxinxi.service.organize.OrganizeService;
import com.yuanmaxinxi.service.resource.ResourceService;
@RequestMapping("/dept")
@Controller
public class DeptController {
	@Autowired
	private DeptService deptService;
	@Autowired
	private OrganizeService organizeService;
	@Autowired
	private ResourceService resourceService;
	@RequestMapping("/list")
	public String list(Model model,HttpSession session) {
		List<Dept> list = deptService.selectAll();
		model.addAttribute("list", list);
		Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/dept/list",loginAdmin.getId());
		List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/dept/list",loginAdmin.getId());
		model.addAttribute("btn1s", btn1s);
		model.addAttribute("btn2s", btn2s);
		return "dept/list";
	}
	@RequestMapping("/showAdd")
	public String showAdd(Model model) {
		List<Organize> list = organizeService.selectAll();
		model.addAttribute("list", list);
		return "dept/add";
	}
	@RequestMapping("/add")
	public @ResponseBody ResultDTO add(Dept obj) {
		ResultDTO dto;
		try {
			deptService.insert(obj);
			dto = ResultDTO.getIntance(true, "部门添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/showEdit")
	public String showEdit(Long id,Model model) {
		Dept obj = deptService.selectOneById(id);
		model.addAttribute("obj", obj);
		List<Organize> list = organizeService.selectAll();
		model.addAttribute("list", list);
		return "dept/edit";
	}
	@RequestMapping("/edit")
	public @ResponseBody ResultDTO edit(Dept obj) {
		ResultDTO dto;
		try {
			deptService.update(obj);
			dto = ResultDTO.getIntance(true, "部门修改成功!");
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
			deptService.delete(id);
			dto = ResultDTO.getIntance(true, "部门删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
}
