package com.yuanmaxinxi.web.electionman;

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

import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.electionman.Electionman;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.dept.DeptService;
import com.yuanmaxinxi.service.electionman.ElectionmanService;
import com.yuanmaxinxi.service.resource.ResourceService;

/**
 * 
* @ClassName: electionmanController
* @Description: TODO 预选人相关
* @author Liudan
* @date 2018年11月29日
*
 */
@Controller
@RequestMapping("/electionman")
public class ElectionmanController {
	@Autowired
	private ElectionmanService electionmanService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 
	* @Title: selectAll
	* @Description: TODO 预选人列表
	* @param @param map 参数
	* @return List<electionman>    返回类型
	* @throws
	 */
	@GetMapping("/list")
	public String electionmanlist(Model model,HttpServletRequest request) {
		Map<String,Object> map=new HashMap<String,Object>();
//		String name=request.getParameter("name");
//		map.put("name", name);
		Admin loginAdmin = (Admin)request.getSession().getAttribute("loginAdmin");
		List<Electionman> list=electionmanService.selectAll(map,loginAdmin.getId());
		model.addAttribute("list",list);	
		List<Resource> btn1s = resourceService.selectAllTypeByAdminIdAndUrl(1,"/electionman/list",loginAdmin.getId());
		List<Resource> btn2s = resourceService.selectAllTypeByAdminIdAndUrl(2,"/electionman/list",loginAdmin.getId());
		model.addAttribute("btn1s", btn1s);
		model.addAttribute("btn2s", btn2s);
		return "/electionman/list";
	}
	@RequestMapping("/showRemark")
	public String showRemark(Model model,Long id) {
		Electionman obj = electionmanService.selectOneById(id);
		model.addAttribute("obj", obj);
		return "electionman/remark";
	}
	@RequestMapping("/showadd")
	public String showAdd() {
		return "electionman/add";
	}
	/**
	 * 
	* @Title: electionmanadd
	* @Description: TODO 添加预选人
	* @param @return    参数
	* @throws
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public ResultDTO electionmanadd(Electionman obj) {
		ResultDTO dto;
		try {
			electionmanService.insert(obj);
			dto = ResultDTO.getIntance(true, "预选人员添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/showEdit")
	public String showEdit(Long id,Model model) {
		Electionman obj = electionmanService.selectOneById(id);
		model.addAttribute("obj", obj);
		Dept dept = deptService.selectOneAndParentOrgById(obj.getDeptId());
		model.addAttribute("dept", dept);
		return "electionman/edit";
	}
	@RequestMapping("/showExamine")
	public String showExamine(Long id,Model model) {
		Electionman obj = electionmanService.selectOneById(id);
		model.addAttribute("obj", obj);
		Dept dept = deptService.selectOneAndParentOrgById(obj.getDeptId());
		model.addAttribute("dept", dept);
		return "electionman/examine";
	}
	@RequestMapping(value = "/isEdit")
	@ResponseBody
	public ResultDTO isEdit(Long id) {
		ResultDTO dto;
		Electionman obj = electionmanService.selectOneById(id);
		//审核中和审核失败可以修改
		if (obj!=null&&(obj.getState()==0||obj.getState()==2)) {
			dto = ResultDTO.getIntance(true,"可以修改");
		}else {
			dto = ResultDTO.getIntance(false, "该参选人员["+obj.getName()+"]已经审核通过,不能修改.");
		}
		return dto;
	}
	@RequestMapping(value = "/isExamine")
	@ResponseBody
	public ResultDTO examine(Long id) {
		ResultDTO dto;
		Electionman obj = electionmanService.selectOneById(id);
		if (obj!=null&&obj.getState()!=0) {
			dto = ResultDTO.getIntance(false, "该参选人员["+obj.getName()+"]已经审核完成,不能重复审核.");
		}else {
			dto = ResultDTO.getIntance(true, "可以审核!");
		}
		return dto;
	}
	@RequestMapping(value = "/examine")
	@ResponseBody
	public ResultDTO examine(Electionman obj) {
		ResultDTO dto;
		try {
			electionmanService.examine(obj);
			dto = ResultDTO.getIntance(true, "审核完成并将该预选人员成功设置到默认投票活动中!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}

	/**
	 * 
	* @Title: electionmanupdate
	* @Description: TODO 修改预选人
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping(value = "/edit")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public ResultDTO electionmanedit(Electionman obj) {
		ResultDTO dto;
		try {
			obj.setFail("");
			//修改之后重新审核
			obj.setState(0);
			electionmanService.update(obj);
			dto = ResultDTO.getIntance(true, "预选人信息修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
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
		try {
			electionmanService.delete(id);
			dto = ResultDTO.getIntance(true, "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
    }
	
}
