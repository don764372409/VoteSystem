package com.yuanmaxinxi.web.articletype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.service.articletype.ArticleTypeService;
	@RestController
	@RequestMapping(value ="/articletype",method = { RequestMethod.GET, RequestMethod.POST })
	public class ArticleTypeController {

	    @Autowired
	    ArticleTypeService articTypeleService;

	    @RequestMapping(value = "/delete", method = RequestMethod.GET)
	    @ResponseBody
		public int delete(Long atid) {
			int result = articTypeleService.delete(atid);
				return result;
			
		}
	 
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(ArticleType obj) {
			int result = articTypeleService.update(obj);
			if (result >= 1) {
				return "修改成功";
			} else {
				return "修改失败";
			}
	 
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public int insert(ArticleType obj) {
			return articTypeleService.insert(obj);
			}
		
		@RequestMapping(value = "/getAll")
		public ModelAndView getAllRuntype() {
			ModelAndView modelAndView = new ModelAndView();
			List<ArticleType> articletypes = articTypeleService.selectAll();
			for (ArticleType articletype : articletypes) {
				System.out.println(articletype.getAtname());
			}
			modelAndView.addObject("articletype", articletypes);
			modelAndView.setViewName("/articletype/list");

			return modelAndView;
		}
	 
		@RequestMapping("/selectOneById")
		@ResponseBody
		public ArticleType selectOneById(Long id){
			return articTypeleService.selectOneById(id);
		}
	}
