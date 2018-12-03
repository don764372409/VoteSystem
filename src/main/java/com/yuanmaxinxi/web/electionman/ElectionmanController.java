package com.yuanmaxinxi.web.candidate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.yuanmaxinxi.domain.candidate.Candidate;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.candidate.CandidateService;

/**
 * 
* @ClassName: CandidateController
* @Description: TODO 预选人相关
* @author Liudan
* @date 2018年11月29日
*
 */
@Controller
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
	* @Description: TODO 添加、修改预选人:待修改
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView candidateadd(ModelAndView model, HttpServletRequest request,
		@RequestParam(value = "id",required = false) Long id) {
		ResultDTO dto;
		if(request.getParameter("add") !=null &&request.getParameter("add").equals("addok")){
			Candidate cd=new Candidate();
			String name=request.getParameter("name");
			cd.setName(name);
			if(id!=null&&id>0) {//判断是修改还是添加
				int c=candidateservice.update(cd);
				if(c>0) {
				dto = ResultDTO.getIntance(true,"修改成功");
				model.setViewName("/candidate/update");
				}else {
					dto = ResultDTO.getIntance(false,"修改失败");
				}
			}else {
				int c=candidateservice.insert(cd);
				if(c>0) {
					dto = ResultDTO.getIntance(true,"添加成功");
					model.setViewName("/candidate/list");
				}else {
					dto = ResultDTO.getIntance(false,"添加失败");
				}
			}
		}
		return model;
	}

	
/**
 * 
* @Title: delete
* @Description: TODO(删除一条预选人)
* @param  id
* @return boolean    返回类型
* @throws
 */
	@RequestMapping(value = "/delete")
	@ResponseBody
    public ResultDTO delete( Long id){
		ResultDTO dto;
		int del=candidateservice.delete(id);
		if(del>0) {
			dto = ResultDTO.getIntance(true,"删除成功");
		}else {
			dto = ResultDTO.getIntance(false,"删除失败");
		}
		return dto;
    }
	
}
