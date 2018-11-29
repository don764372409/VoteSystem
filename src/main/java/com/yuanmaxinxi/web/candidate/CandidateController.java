package com.yuanmaxinxi.web.candidate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.yuanmaxinxi.domain.candidate.Candidate;
import com.yuanmaxinxi.service.candidate.CandidateService;

/**
 * 
* @ClassName: CandidateController
* @Description: TODO 预选人相关
* @author Liudan
* @date 2018年11月29日
*
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	CandidateService candidateservice;
	
	/**
	 * 
	* @Title: selectAll
	* @Description: TODO 预选人列表
	* @param @param map 参数
	* @return List<Candidate>    返回类型
	* @throws
	 */
	@GetMapping("/list")
	public ModelAndView candidatelist(ModelAndView modelView,HttpServletRequest request) {
		Map<String,Object> map=new HashMap<String,Object>();
		String name=request.getParameter("name");
		map.put("name", name);
		List<Candidate> candidatelist=candidateservice.selectAll(map);
		modelView.addObject("candidatelist", candidatelist);	
		modelView.setViewName("/candidate/list");
		return modelView;
	}
	
	/**
	 * 
	* @Title: candidateadd
	* @Description: TODO 添加预选人
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView candidateadd(ModelAndView model) {
//		candidateservice.insert(obj);
		model.setViewName("/candidate/add");
		return model;
	}
	
	
	
}
