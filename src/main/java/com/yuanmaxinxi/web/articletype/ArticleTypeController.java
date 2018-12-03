package com.yuanmaxinxi.web.articletype;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.dto.ResultDTO;
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
		@RequestMapping("/dd")
		public String showAdd() {
			return "admin/add";
		}
	    @RequestMapping(value = "/list")
		public ModelAndView List(Long id) {
			ModelAndView modelAndView = new ModelAndView();
			List<ArticleType> articletypes = articTypeleService.selectAll(id);
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
