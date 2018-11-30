package com.yuanmaxinxi.web.voting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yuanmaxinxi.domain.candidate.Candidate;
import com.yuanmaxinxi.domain.voting.Voting;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.voting.VotingService;

/**
 * 
* @ClassName: VoteController
* @Description: TODO(投票相关)
* @author Liudan
* @date 2018年11月29日
*
 */
@RestController
@RequestMapping("/vote")
public class VoteController {
	@Autowired
    VotingService votingservice;
	
	/**
	 * 
	* @Title: votinglist
	* @Description: TODO 投票活动列表
	* @param @param map 参数
	* @return List<Candidate>    返回类型
	* @throws
	 */
	@GetMapping("/list")
	public ModelAndView votinglist(ModelAndView modelView,HttpServletRequest request) {
		Map<String,Object> map=new HashMap<String,Object>();
		String name=request.getParameter("name");
		map.put("name", name);
		List<Voting> votinglist=votingservice.selectAll(map);
		modelView.addObject("voting", votinglist);	
		modelView.setViewName("/vote/list");
		return modelView;
	}
	
	/**
	 * 
	* @Title: delete
	* @Description: TODO(删除一条投票活动)
	* @param  id
	* @return boolean    返回类型
	* @throws
	 */
		@RequestMapping(value = "/delete")
		@ResponseBody
		 public ResultDTO delete( Long id){
			ResultDTO dto;
			int del=votingservice.delete(id);
			if(del>0) {
				dto = ResultDTO.getIntance(true,"删除成功");
			}else {
				dto = ResultDTO.getIntance(false,"删除失败");
			}
			return dto;
	    }

		/**
		 * 
		* @Title: voteupdate
		* @Description: TODO(添加、修改投票活动)
		* @param  model
		* @param  request
		* @param  id
		* @return ModelAndView    返回类型
		* @throws
		 */
		@RequestMapping(value = "/update")
		@ResponseBody
		@Transactional(rollbackFor = Exception.class)
		public ModelAndView voteupdate(ModelAndView model, HttpServletRequest request,
			@RequestParam(value = "id",required = false) Long id) {
			ResultDTO dto;
			if(request.getParameter("add") !=null &&request.getParameter("add").equals("addok")){
				Voting vt=new Voting();
				String title=request.getParameter("title");
				vt.setTitle(title);
				if(id!=null&&id>0) {//判断是修改还是添加
					int c=votingservice.update(vt);
					if(c>0) {
					dto = ResultDTO.getIntance(true,"修改成功");
					model.setViewName("/vote/update");
					}else {
						dto = ResultDTO.getIntance(false,"修改失败");
					}
				}else {
					int c=votingservice.insert(vt);
					if(c>0) {
						dto = ResultDTO.getIntance(true,"添加成功");
						model.setViewName("/vote/list");
					}else {
						dto = ResultDTO.getIntance(false,"添加失败");
					}
				}
			}
			return model;
		}
		

}
