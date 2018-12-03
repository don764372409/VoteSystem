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
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.article.ArticleService;
import com.yuanmaxinxi.service.articletype.ArticleTypeService;



@Controller
@RequestMapping(value ="/article",method = { RequestMethod.GET, RequestMethod.POST })
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
	private ArticleTypeService articletypeService;
	@RequestMapping("/showAdd")
	public String showAdd() {
		return "/article/add";
	}
	 @RequestMapping("/add")
		public @ResponseBody ResultDTO add(Article obj) {
			ResultDTO dto;
			try {
				articleService.insert(obj);
				dto = ResultDTO.getIntance(true, "类别添加成功!");
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
				dto = ResultDTO.getIntance(true, "类别删除成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
		}
	  @RequestMapping("/showEdit")
			public String showEdit(Model model,Long id) {
		    	Article obj = articleService.selectOneById(id);
				model.addAttribute("obj", obj);
				return "/articletype/edit";
			}
	  @RequestMapping("/showType")
		public String showType(Model model) {
			List<ArticleType> list = articletypeService.selectArticleTypeToTree();
			model.addAttribute("list", list);
			System.err.println(list);
			return "articletype/organize";
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
}
