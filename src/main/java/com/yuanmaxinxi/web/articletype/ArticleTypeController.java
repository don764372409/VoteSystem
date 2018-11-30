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
	    @RequestMapping(value = "/update")
		@ResponseBody
		@Transactional(rollbackFor = Exception.class)
		public ModelAndView candidateadd(ModelAndView model, HttpServletRequest request,
			@RequestParam(value = "atid",required = false) Long atid) {
			ResultDTO dto;
			if(request.getParameter("add") !=null &&request.getParameter("add").equals("addok")){
				ArticleType cd=new ArticleType();
				String name=request.getParameter("name");
				cd.setAtname(name);
				if(atid!=null&&atid>0) {//判断是修改还是添加
					int c=articTypeleService.update(cd);
					if(c>0) {
					dto = ResultDTO.getIntance(true,"修改成功");
					model.setViewName("/articletype/update");
					}else {
						dto = ResultDTO.getIntance(false,"修改失败");
					}
				}else {
					int c=articTypeleService.insert(cd);
					if(c>0) {
						dto = ResultDTO.getIntance(true,"添加成功");
						model.setViewName("/articletype/list");
					}else {
						dto = ResultDTO.getIntance(false,"添加失败");
					}
				}
			}
			return model;
		}
	    @RequestMapping(value = "/list")
		public ModelAndView List(Long atid) {
			ModelAndView modelAndView = new ModelAndView();
			List<ArticleType> articletypes = articTypeleService.selectAll(atid);
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
