package com.yuanmaxinxi.web.articletype;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.articletype.ArticleTypeService;
import com.yuanmaxinxi.service.resource.ResourceService;
	@Controller
	@RequestMapping(value ="/articletype",method = { RequestMethod.GET, RequestMethod.POST })
	public class ArticleTypeController {

	    @Autowired
	    ArticleTypeService articTypeleService;
		@Autowired
		private ArticleTypeService atService;
		@Autowired
		private ResourceService resourceService;
	    @RequestMapping("/delete")
		public @ResponseBody ResultDTO delete(Long id) {
			ResultDTO dto;
			try {
				articTypeleService.delete(id);
				dto = ResultDTO.getIntance(true, "类别删除成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
		}
	    
	    @RequestMapping("/list")
		public String list(Model model,Long pId,HttpServletRequest request) {
	    	Admin loginAdmin = (Admin)request.getSession().getAttribute("loginAdmin");
	    	if(pId==1) {
	    		
	    		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/articletype/list?pId=1",loginAdmin.getId());
				List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/articletype/list?pId=1",loginAdmin.getId());
				model.addAttribute("btn1s", btn1s);
				model.addAttribute("btn2s", btn2s);
	    	}else if(pId==2) {
	    		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/articletype/list?pId=2",loginAdmin.getId());
				List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/articletype/list?pId=2",loginAdmin.getId());
				model.addAttribute("btn1s", btn1s);
				model.addAttribute("btn2s", btn2s);
	    	}else if(pId==3) {
	    		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/articletype/list?pId=3",loginAdmin.getId());
				List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/articletype/list?pId=3",loginAdmin.getId());
				model.addAttribute("btn1s", btn1s);
				model.addAttribute("btn2s", btn2s);
	    	}
			List<ArticleType> list = articTypeleService.selectAll(pId);
			model.addAttribute("list", list);
			return "/articletype/list";
		}
	    @RequestMapping("/showAdd")
		public String showAdd(Model model,Long pid) {
			List<ArticleType> list = atService.selectAll(pid);
			model.addAttribute("list", list);
			return "/articletype/add";
		}
	    @RequestMapping("/add")
		public @ResponseBody ResultDTO add(ArticleType obj) {
			ResultDTO dto;
			try {
				articTypeleService.insert(obj);
				dto = ResultDTO.getIntance(true, "类别添加成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
		}
	    @RequestMapping("/showEdit")
		public String showEdit(Model model,Long id) {
	    	ArticleType obj = articTypeleService.selectOneById(id);
			model.addAttribute("obj", obj);
			return "/articletype/edit";
		}
	    @RequestMapping("/edit")
		public @ResponseBody ResultDTO edit(ArticleType obj) {
			ResultDTO dto;
			try {
				articTypeleService.update(obj);
				dto = ResultDTO.getIntance(true, "类别修改成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
		}
		@RequestMapping("/selectOneById")
		@ResponseBody
		public ArticleType selectOneById(Long id){
			return articTypeleService.selectOneById(id);
		}
	}
