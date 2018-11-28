package com.yuanmaxinxi.web.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuanmaxinxi.domain.article.Article;
import com.yuanmaxinxi.service.article.ArticleService;



@RestController
@RequestMapping(value ="/article",method = { RequestMethod.GET, RequestMethod.POST })
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		int result = articleService.delete(Long.parseLong(id));
		if (result >= 1) {
			return "删除成功";
		} else {
			return "删除失败";
		}
	}
 
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
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Article> selectAll(){
		return articleService.selectAll();
	}
 
	@RequestMapping("/selectOneById")
	@ResponseBody
	public Article selectOneById(Long id){
		return articleService.selectOneById(id);
	}
}
