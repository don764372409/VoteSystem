package com.yuanmaxinxi.web.wechat;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.yuanmaxinxi.service.votingelectionman.VotingelectionmanService;

@Controller
public class WechatController {
	
	@Autowired
	private VotingelectionmanService veservice;
	
	/**
	 * 
	* @Title: wechatvlist
	* @Description: TODO(微信投票选手展示页)
	* @param @param model
	* @param @param request
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@GetMapping("/wechatvlist")
	public String wechatlist(Model model,HttpServletRequest request) {
		List<Map<String, Object>> list=veservice.getwechatelist();
		model.addAttribute("list",list);
		return "/wechat/votinglist";
	}
	
}
