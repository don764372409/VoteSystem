package com.yuanmaxinxi.web.wechat;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.article.Article;
import com.yuanmaxinxi.service.article.ArticleService;
import com.yuanmaxinxi.service.votingelectionman.VotingelectionmanService;
import com.yuanmaxinxi.util.StringUtil;

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
	@RequestMapping("/wechatvlist")
	public String wechatlist(Model model) {
		List<Map<String, Object>> list=veservice.getwechatelist();
		model.addAttribute("list",list);
		return "/wechat/votinglist";
	}
	/*获取全部公司列表*/
	@RequestMapping("/getallorganize")
	@ResponseBody  
	public List<Map<String, Object>> getallorganize() {
		List<Map<String, Object>> alllist= veservice.getallorganize();
		return alllist;
	}
	
	/*根据所选公司获取部门*/
	@RequestMapping("/getalldept")
	@ResponseBody
	public List<Map<String, Object>> getalldept(Long id) {
		List<Map<String, Object>> dptlist= veservice.getalldept(id);
		return dptlist;
	}
	/*根据部门获取该部门参选人*/
	@RequestMapping("/getallvoter")
	@ResponseBody
	public List<Map<String, Object>> getallvoter(Long id) {
		List<Map<String, Object>> voterlist= veservice.getallvoter(id);
		return voterlist;
	}
	
	/*ajax搜索选手内容*/
	@RequestMapping("/chagewechatvlist")
	@ResponseBody
	public List<Map<String, Object>> chagewechatvlist(Model model,@RequestParam(value = "dept", required = false) Long dept,
			@RequestParam(value = "name", required = false) String name) {
		Long deptId=(long) 0; String names="";String type="3";
		if(dept!=null && dept>0) {
			deptId=dept;
		}
		if(name!=null && name!="" ) {
		if(StringUtil.isNumeric(name) ==true) {
			 type="1";
			names=name;
		}else {
			type="2";
			names=name;
		}
		}
		List<Map<String, Object>> list=veservice.chagewechatvlist(deptId,type,names);
		return list;
	}
	
	
}
