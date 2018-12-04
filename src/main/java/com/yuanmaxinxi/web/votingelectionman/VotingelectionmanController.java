package com.yuanmaxinxi.web.votingelectionman;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	/**
	 * 
	* @Title: list
	* @Description: TODO(投票参选人列表)
	* @param  model
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/votingelection/list")
	public String list(Model model) {
		List<Map<String, Object>> list = veservice.selectAll();
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
	public String statistics(Model model) {
//		List<Map<String, Object>> list = veservice.selectAll();
//		model.addAttribute("list", list);
		return "/votestatistics/statistics";
	}
	
	
}
