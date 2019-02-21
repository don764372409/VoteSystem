package com.yuanmaxinxi.web.article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.article.Article;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.admin.AdminService;
import com.yuanmaxinxi.service.article.ArticleService;
import com.yuanmaxinxi.service.articletype.ArticleTypeService;
import com.yuanmaxinxi.service.dept.DeptService;
import com.yuanmaxinxi.service.resource.ResourceService;
import com.yuanmaxinxi.util.Pager;
import com.yuanmaxinxi.util.StringUtil;



@Controller
@RequestMapping(value ="/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
	private ArticleTypeService articletypeService;
    @Autowired
	private ResourceService resourceService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private DeptService deptService;
    @RequestMapping("/showAdd")
	public String showAdd(Model model,Long pId,HttpSession session) {
    	//获取发布者的名字和部门
    	Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
		Admin admin = adminService.selectOneById(loginAdmin.getId());
		model.addAttribute("admin", admin);
    	List<ArticleType> list = articletypeService.selectTypeToTree(pId);
		model.addAttribute("list", list);
		return "/article/add";
	}
    @RequestMapping("/add")
	public @ResponseBody ResultDTO add(Article obj) {
		ResultDTO dto;
		try {
			articleService.insert(obj);
			dto = ResultDTO.getIntance(true, "文章添加成功!");
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
				articleService.delete(id);
				dto = ResultDTO.getIntance(true, "文章删除成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
		}
	 @RequestMapping("/showRemark")
		public String showRemark(Model model,Long id) {
		 Article obj = articleService.selectOneById(id);
			model.addAttribute("obj", obj);
			List<ArticleType> list = articletypeService.selectTypeToTree(id);
			model.addAttribute("list", list);
			return "/article/remark";
		}
	 @RequestMapping("/showEdit")
		public String showEdit(Model model,Long id,Long pId) {
	    	Article obj = articleService.selectOneById(id);
			model.addAttribute("obj", obj);
			List<ArticleType> list = articletypeService.selectTypeToTree(pId);
			model.addAttribute("list", list);
			Dept dept = deptService.selectOneAndParentOrgById(obj.getAdId());
			model.addAttribute("dept", dept);
			return "/article/edit";
		}
	    @RequestMapping("/edit")
		public @ResponseBody ResultDTO edit(Article obj) {
			ResultDTO dto;
			System.err.println(obj);
			try {
				obj.setFail("");
				obj.setState(0);
				articleService.update(obj);
				dto = ResultDTO.getIntance(true, "修改成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
		}
	@RequestMapping("/list")
	public String list(Model model,Long pId,HttpServletRequest request) {
		Map<String,Object> map=new HashMap<String,Object>();
		Admin loginAdmin = (Admin)request.getSession().getAttribute("loginAdmin");
    	if(pId==1) {
    		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/article/list?pId=1",loginAdmin.getId());
			List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/article/list?pId=1",loginAdmin.getId());
			model.addAttribute("btn1s", btn1s);
			model.addAttribute("btn2s", btn2s);
    	}else if(pId==2) {
    		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/article/list?pId=2",loginAdmin.getId());
			List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/article/list?pId=2",loginAdmin.getId());
			model.addAttribute("btn1s", btn1s);
			model.addAttribute("btn2s", btn2s);
    	}else if(pId==3) {
    		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/article/list?pId=3",loginAdmin.getId());
			List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/article/list?pId=3",loginAdmin.getId());
			model.addAttribute("btn1s", btn1s);
			model.addAttribute("btn2s", btn2s);
    	}
		List<Article> list = articleService.selectAll(map,pId,loginAdmin.getId());
		model.addAttribute("list", list);
		Admin admin = adminService.selectOneById(loginAdmin.getId());
		model.addAttribute("admin", admin);
		return "/article/list";
	}
	@RequestMapping("/selectOneById")
	@ResponseBody
	public Article selectOneById(Long id){
		return articleService.selectOneById(id);
	}
	@RequestMapping("/showExamine")
	public String showExamine(Long id,Model model) {
		Article obj = articleService.selectOneById(id);
		model.addAttribute("obj", obj);
		List<ArticleType> list = articletypeService.selectTypeToTree(id);
		model.addAttribute("list", list);
		return "article/examine";
	}
	@RequestMapping(value = "/isExamine")
	@ResponseBody
	public ResultDTO examine(Long id) {
		ResultDTO dto;
		Article obj = articleService.selectOneById(id);
		if (obj!=null&&obj.getState()!=0) {
			dto = ResultDTO.getIntance(false, "文章["+obj.getTitle()+"]已经审核完成,不能重复审核.");
		}else {
			dto = ResultDTO.getIntance(true, "可以审核!");
		}
		return dto;
	}
	@RequestMapping(value = "/examine")
	@ResponseBody
	public ResultDTO examine(Article obj) {
		ResultDTO dto;
		try {
			articleService.examine(obj);
			dto = ResultDTO.getIntance(true, "审核完成并将该文章推送到首页中!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/showIndex")
	public String showIndex(Model model,Long id) {
	 Article obj = articleService.selectOneById(id);
		model.addAttribute("obj", obj);
		return "/wechat/article";
	}
	@RequestMapping("/index")
	public  String indexShow(Model model,Long aId) {
		Pager pager=new Pager();
		List<Article> list = articleService.indexShow(aId,pager.getStartRecord(),pager.getPageSize());
		model.addAttribute("list", list);
		return "/wechat/index";
	}
	@RequestMapping(value = "/more")
	@ResponseBody
	public List<Article> more(Model model,Long aId,@RequestParam(value = "startrecord", required = false) Integer  startrecord) {
		Pager pager=new Pager();
		List<Article> list = articleService.indexShow(aId,startrecord,pager.getPageSize());
		model.addAttribute("list", list);
		for(Article l:list) {
			l.setTimechange(StringUtil.DateToStr(l.getTime()));	
		}
		return list;
	}
}
