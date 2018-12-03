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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.electionman.Electionman;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.dept.DeptService;
import com.yuanmaxinxi.service.electionman.ElectionmanService;

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
public class ElectionmanController {

	@Autowired
	ElectionmanService candidateservice;
	@Autowired
	private DeptService deptService;
	
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
		List<Electionman> candidatelist=candidateservice.selectAll(map);
		modelView.addObject("candidatelist", candidatelist);	
		modelView.setViewName("/candidate/list");
		return modelView;
	}
	@RequestMapping("/showadd")
	public String showAdd(Model model) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Electionman> list = candidateservice.selectAll(map);
		model.addAttribute("list", list);
		List<Dept> lists = deptService.selectAll();//部门列表展示
		model.addAttribute("lists", lists);
		return "candidate/add";
	}
	/**
	 * 
	* @Title: candidateadd
	* @Description: TODO 添加预选人
	* @param @return    参数
	* @throws
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public ResultDTO candidateadd(Electionman obj) {
		ResultDTO dto;
		try {
			obj.setImg("http://img4.imgtn.bdimg.com/it/u=2841318189,2319887386&fm=214&gp=0.jpg");
			obj.setRemark("优秀干部");
			obj.setFail("fail");
			obj.setDeptId((long) 1);
			candidateservice.insert(obj);
			dto = ResultDTO.getIntance(true, "预选人添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/showEdit")
	public String showEdit(Long id,Model model) {
		Electionman obj = candidateservice.selectOneById(id);
		model.addAttribute("obj", obj);
		List<Dept> list = deptService.selectAll();//部门列表展示
		model.addAttribute("list", list);
		return "candidate/edit";
	}

	/**
	 * 
	* @Title: candidateupdate
	* @Description: TODO 修改预选人
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping(value = "/edit")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public ResultDTO candidateedit(Electionman obj) {
		ResultDTO dto;
		try {
			obj.setImg("http://img4.imgtn.bdimg.com/it/u=2841318189,2319887386&fm=214&gp=0.jpg");
			obj.setRemark("优秀干部");
			obj.setFail("fail");
			obj.setDeptId((long) 5);
			candidateservice.update(obj);
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
			candidateservice.delete(id);
			dto = ResultDTO.getIntance(true, "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
    }
	
}
