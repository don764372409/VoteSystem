package com.yuanmaxinxi.web.votingelectionman;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.voting.Voting;
import com.yuanmaxinxi.service.voting.VotingService;
import com.yuanmaxinxi.service.votingelectionman.VotingelectionmanService;

/**
 * 
* @ClassName: VotingelectionmanController
* @Description: TODO(投票活动和参选人关联表相关)
* @author Liudan
* @date 2018年12月4日
*
 */
@Controller
public class VotingelectionmanController {
	
	@Autowired
	VotingelectionmanService veservice;
	@Autowired
    VotingService votingservice;
	
	/**
	 * 
	* @Title: list
	* @Description: TODO(投票参选人列表)
	* @param  model
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/votingelection/list")
	public String list(Model model,HttpServletRequest request) {
		Admin loginAdmin = (Admin)request.getSession().getAttribute("loginAdmin");
		List<Map<String, Object>> list = veservice.selectAll(loginAdmin.getId());
		model.addAttribute("list", list);
		return "votingelection/list";
	}
	
	/**
	 * 
	* @Title: statistics
	* @Description: TODO(投票统计)
	* @param @param model
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/votestatistics/statistics")
	public String statistics(Model model,@RequestParam(value = "id", required = false) Long id) {
		List<Voting> list=votingservice.selectvotinglist();//活动分类列表
		Long vid=(long) 0;
		if(id!=null && id>0) {
			vid=id;
		}
		List<Map<String, Object>> map = veservice.getstatistics(vid);//展示数据
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		model.addAttribute("vid", vid);
		return "/votestatistics/statistics";
	}
	
	
}
