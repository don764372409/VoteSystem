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
	 @RequestMapping("/showEdit")
		public String showEdit(Long id,Model model,Long pid) {
		    Article obj = articleService.selectOneById(id);
			model.addAttribute("obj", obj);
			List<ArticleType> list = articletypeService.selectAll(pid);//部门列表展示
			model.addAttribute("list", list);
			return "article/edit";
		}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Article> list = articleService.selectAll();
		model.addAttribute("list", list);
		return "article/list";
	}
	@RequestMapping("/selectOneById")
	@ResponseBody
	public Article selectOneById(Long id){
		return articleService.selectOneById(id);
	}
	@RequestMapping("/showType")
	public String showOrg(Model model) {
		
		return "article/organize";
	}
}
