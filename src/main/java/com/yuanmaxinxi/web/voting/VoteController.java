package com.yuanmaxinxi.web.voting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.domain.voting.Voting;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.electionman.ElectionmanService;
import com.yuanmaxinxi.service.resource.ResourceService;
import com.yuanmaxinxi.service.voting.VotingService;

/**
 * 
* @ClassName: VoteController
* @Description: TODO(投票相关)
* @author Liudan
* @date 2018年11月29日
*
 */
@Controller
@RequestMapping("/vote")
public class VoteController {
	@Autowired
    VotingService votingservice;
	@Autowired
	ElectionmanService candidateservice;
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 
	* @Title: votinglist
	* @Description: TODO 投票活动列表
	* @param @param map 参数
	* @return List<Candidate>    返回类型
	* @throws
	 */
	@GetMapping("/list")
	public String votinglist(Model model,HttpServletRequest request) {
		Admin loginAdmin = (Admin)request.getSession().getAttribute("loginAdmin");
		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/vote/list",loginAdmin.getId());
		List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/vote/list",loginAdmin.getId());
		Map<String,Object> map=new HashMap<String,Object>();
		String name=request.getParameter("name");
		map.put("name", name);
		List<Voting> votinglist=votingservice.selectAll(map);
		model.addAttribute("btn1s", btn1s);
		model.addAttribute("btn2s", btn2s);
		model.addAttribute("voting", votinglist);
		return "/vote/list";
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
			try {
				votingservice.delete(id);
				dto = ResultDTO.getIntance(true, "删除成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
	    }

		@RequestMapping("/showadd")
		public String showAdd(Model model) {
			Map<String,Object> map=new HashMap<String,Object>();
			List<Voting> list = votingservice.selectAll(map);
			model.addAttribute("list", list);
			return "vote/add";
		}
		/**
		 * 
		* @Title: votingadd
		* @Description: TODO 添加投票活动
		* @throws
		 */
		@RequestMapping(value = "/add")
		@ResponseBody
		@Transactional(rollbackFor = Exception.class)
		public ResultDTO votingadd(Voting obj,HttpServletRequest request) {
			ResultDTO dto;
			try {
				votingservice.insert(obj,request);
				dto = ResultDTO.getIntance(true, "投票活动添加成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
		}
		@RequestMapping("/showEdit")
		public String showEdit(Long id,Model model) {
			Voting obj = votingservice.selectOneById(id);
			model.addAttribute("obj", obj);
			return "vote/edit";
		}

		/**
		 * 
		* @Title: voting
		* @Description: TODO 修改投票活动
		* @throws
		 */
		@RequestMapping(value = "/edit")
		@ResponseBody
		@Transactional(rollbackFor = Exception.class)
		public ResultDTO votingedit(Voting obj,HttpServletRequest request) {
			ResultDTO dto;
			try {
				votingservice.update(obj,request);
				dto = ResultDTO.getIntance(true, "投票活动修改成功!");
			} catch (Exception e) {
				e.printStackTrace();
				dto = ResultDTO.getIntance(false, e.getMessage());
			}
			return dto;
		}
		
		

}
