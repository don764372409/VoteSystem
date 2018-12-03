package com.yuanmaxinxi.web.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yuanmaxinxi.domain.article.Article;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.service.article.ArticleService;
import com.yuanmaxinxi.service.articletype.ArticleTypeService;
import com.yuanmaxinxi.service.organize.OrganizeService;



@RestController
@RequestMapping(value ="/article",method = { RequestMethod.GET, RequestMethod.POST })
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
	private ArticleTypeService articletypeService;
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
	public int delete(Long atpid) {
		int result = articleService.delete(atpid);
			return result;
		
	}
	@RequestMapping("/showAdd")
	public String showAdd() {
		return "/article/add";
	}
//	@RequestMapping("/showType")
//	public String showOrg(Model model) {
//		List<ArticleType> list = articletypeService.selectOrgAndeDeptToTree();
//		model.addAttribute("list", list);
//		System.err.println(list);
//		return "article/organize";
//	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Article obj) {
		int result = articleService.update(obj);
		if (result >= 1) {
			return "修改成功";
		} else {
			return "修改失败";
		}
 
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public int insert(Article obj) {
		return articleService.insert(obj);
		}
	
	@RequestMapping(value = "/list")
	public ModelAndView getAllRuntype(Long pid) {
		ModelAndView modelAndView = new ModelAndView();
		List<Article> articles = articleService.selectAll();
		modelAndView.addObject("article", articles);
		modelAndView.setViewName("/article/list");

		return modelAndView;
	}
 
	@RequestMapping("/selectOneById")
	@ResponseBody
	public Article selectOneById(Long id){
		return articleService.selectOneById(id);
	}
}
