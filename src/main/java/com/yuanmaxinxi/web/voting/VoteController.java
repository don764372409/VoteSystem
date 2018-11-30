package com.yuanmaxinxi.web.voting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.yuanmaxinxi.domain.voting.Voting;
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
	    public boolean delete( Long id){
			int del=votingservice.delete(id);
			if(del>0) {
				return true;
			}else {
				return false;
			}
	    }
	

}
