package com.yuanmaxinxi.web.wechat;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yuanmaxinxi.domain.electionman.Electionman;
import com.yuanmaxinxi.domain.votingman.Votingman;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.electionman.ElectionmanService;
import com.yuanmaxinxi.service.voting.VotingService;
import com.yuanmaxinxi.service.votingelectionman.VotingelectionmanService;
import com.yuanmaxinxi.service.votingman.VotingmanService;
import com.yuanmaxinxi.util.StringUtil;
import com.yuanmaxinxi.util.IPUtils;
/**
 * 
* @ClassName: WechatController
* @Description: TODO(微信端投票展示相关)
* @author Liudan
* @date 2018年12月7日
*
 */
@Controller
public class WechatController {
	
	@Autowired
	private VotingelectionmanService veservice;
	@Autowired
	private VotingmanService votingmanservice;
	@Autowired
	ElectionmanService electionmanservice;
	@Autowired
	private VotingelectionmanService votingelectionmanservice;
	@Autowired
    VotingService votingservice;
	
	/**
	 * 
	* @Title: wechatvlist
	* @Description: TODO(微信投票选手展示页,未排序)
	* @param  model
	* @param  request
	* @param   参数
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/wechatvlist")
	public String wechatlist(Model model) {
		//这里用来加浏览量
		votingservice.upvist();
		List<Map<String, Object>> list=veservice.getwechatelist();
		Long totle=veservice.gettotle();
		for(Map<String, Object> m:list) {
			Object vist=m.get("vist");
			model.addAttribute("vist",vist);
		}
		model.addAttribute("list",list);
		model.addAttribute("totle",totle);
		return "/wechat/votinglist";
	}
	
	@RequestMapping("/wechatvlists")
	public String wechatlists(Model model) {
		//这里用来加浏览量
		votingservice.upvist();
		List<Map<String, Object>> list=veservice.getwechatelists();
		Long totle=veservice.gettotle();
		for(Map<String, Object> m:list) {
			Object vist=m.get("vist");
			model.addAttribute("vist",vist);
		}
		model.addAttribute("list",list);
		model.addAttribute("totle",totle);
		return "/wechat/votinglist";
	}
	
	/**
	 * 
	* @Title: wechatrule
	* @Description: TODO(微信投票规则展示页)
	* @param  model
	* @param  request
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/wechatrule")
	public String wechatrule(Model model) {
		String rule=votingservice.getvrule();
		model.addAttribute("rule",rule);
		return "/wechat/ruleshow";
	}
	
	/*选手详情*/
	@RequestMapping("/wechatvshow")
	public String wechatvshow(Model model,@RequestParam(value = "id") Long id,@RequestParam(value = "vId") Long vId) {
		Electionman obj=electionmanservice.selectOneById(id);
		model.addAttribute("vId",vId);
		model.addAttribute("obj",obj);
		return "/wechat/votershow";
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
	
	/**
	 * 
	* @Title: wechatvoting
	* @Description: TODO(微信用户投票)
	* @param  id
	* @return ResultDTO    返回类型
	* @throws
	 */
	@RequestMapping(value = "/wechatvoting")
	@ResponseBody
	 public ResultDTO wechatvoting(HttpServletRequest request,Long id,Long vId){
		ResultDTO dto;
		try {
			HttpServletRequest httpRequest=(HttpServletRequest)request; 
			String urls= "http://" + request.getServerName()+ ":"+ request.getServerPort()+ httpRequest.getContextPath() 
			+ httpRequest.getServletPath();
			String openid=IPUtils.getIP(1);		//访问者ip地址
			int t=votingmanservice.selectwechattoday(openid);//是否今日已经投过票
			if(t>0) {
				dto = ResultDTO.getIntance(false, "您今日已经投过票了，请明天再来！");
			}else {
			int v=votingmanservice.selectwechatonly(openid,id);//是否今日已经投过该选手
			if(v>0) {
				dto = ResultDTO.getIntance(false, "您今日已经投过该选手了，不能重复投票！");
			}else {
				synchronized ("NUM") {
				int upnuber=votingelectionmanservice.updatenewnumber(id);//原票数+1
				if(upnuber>0) {//投票成功
				Votingman obj=new Votingman();
				obj.setEId(id);
				obj.setOpenid(openid);
				obj.setVId(vId);
				votingmanservice.insert(obj);//更新投票记录
				dto = ResultDTO.getIntance(true, "投票成功!");
				}else {
				dto = ResultDTO.getIntance(false, "投票失败!");	
				}
				}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, "投票失败!");
		}
		return dto;
    }
	
}
