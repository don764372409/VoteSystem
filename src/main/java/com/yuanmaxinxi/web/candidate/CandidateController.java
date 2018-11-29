package com.yuanmaxinxi.web.candidate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.yuanmaxinxi.domain.candidate.Candidate;
import com.yuanmaxinxi.service.candidate.CandidateService;
import com.yuanmaxinxi.util.Page;

/**
 * 
* @ClassName: CandidateController
* @Description: TODO(预选人相关)
* @author Liudan
* @date 2018年11月29日
*
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	CandidateService candidateservice;
	
	@GetMapping("/list")
	public ModelAndView candidatelist(ModelAndView modelView,Page page) {
		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("startRecord", page.getStartRecord());
//		map.put("pageSize", page.getPageSize());
//		map.put("name", name);
		List<Candidate> candidatelist=candidateservice.selectAll(map);
		page.setTotal(candidateservice.countall(map));
		modelView.addObject("pager", page);
		modelView.addObject("candidatelist", candidatelist);	
		modelView.setViewName("/candidate/list");
		return modelView;
	}
	
}
