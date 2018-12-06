package com.yuanmaxinxi.web.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yuanmaxinxi.domain.article.Article;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.electionman.Electionman;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.article.ArticleService;
import com.yuanmaxinxi.service.articletype.ArticleTypeService;



@Controller
@RequestMapping(value ="/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
	private ArticleTypeService articletypeService;
	
    @RequestMapping("/showAdd")
	public String showAdd(Model model,Long pId) {
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
			return "/article/remark";
		}
	 @RequestMapping("/showEdit")
		public String showEdit(Model model,Long id,Long pId) {
	    	Article obj = articleService.selectOneById(id);
			model.addAttribute("obj", obj);
			List<ArticleType> list = articletypeService.selectTypeToTree(pId);
			model.addAttribute("list", list);
			return "/article/edit";
		}
	    @RequestMapping("/edit")
		public @ResponseBody ResultDTO edit(Article obj) {
			ResultDTO dto;
			try {
				obj.setFail("");
				obj.setState(0);
				articleService.update(obj);
				dto = ResultDTO.getIntance(true, "类别修改成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
		}
	@RequestMapping("/list")
	public String list(Model model,Long pId) {
		List<Article> list = articleService.selectAll(pId);
		model.addAttribute("list", list);
		return "article/list";
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
		System.err.println("---------------");
			articleService.examine(obj);
			dto = ResultDTO.getIntance(true, "审核完成并将该文章推送到首页中!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
}
