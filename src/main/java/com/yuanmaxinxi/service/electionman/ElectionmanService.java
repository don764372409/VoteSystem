package com.yuanmaxinxi.service.electionman;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.electionman.ElectionmanDAO;
import com.yuanmaxinxi.dao.voting.VotingDAO;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.electionman.Electionman;
import com.yuanmaxinxi.service.dept.DeptService;
import com.yuanmaxinxi.util.StringUtil;


@Service
public class ElectionmanService{
	@Autowired
	private ElectionmanDAO electionmanDAO;
	@Autowired
	private DeptService deptService;
	@Autowired
	private VotingDAO votingDAO;
	@Transactional
	public void insert(Electionman obj){
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("预选人名字不能为空.");
		}
		if (obj.getDeptId()==null||obj.getDeptId()<1) {
			throw new RuntimeException("添加预选人时必须选择部门.");
		}
		if (StringUtil.isNullOrEmpty(obj.getImg())) {
			throw new RuntimeException("请上传预选人员展示头像.");
		}
		int i = electionmanDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("添加失败,请稍后重试.");
		}
	}


	@Transactional
	public void update(Electionman obj){
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("预选人名字不能为空.");
		}
		if (obj.getDeptId()==null||obj.getDeptId()<1) {
			throw new RuntimeException("修改预选人时必须选择部门.");
		}
		int i = electionmanDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("修改预选人失败,请稍后重试.");
		}
	}


	@Transactional
	public void delete(Long id){
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
		try {
			int i = electionmanDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("删除失败,请稍后再试.");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("foreign key")) {
				msg = "这个预选人员绑定了其他数据(投票参选人员),不能进行删除哦!";
			}
			throw new RuntimeException(msg);
		}
	}


	public Electionman selectOneById(Long id){
		return electionmanDAO.selectOneById(id);
	}


	public List<Electionman> selectAll( Map map, Long adminId){
		//获取能查那些部门的参选人员
		List<Dept> depts = deptService.selectAllByAdminId(adminId);
		map.put("list", depts);
		List<Electionman> list = electionmanDAO.selectAll(map);
		Map<Long,Dept> cash = new HashMap<>();
		for (Electionman ele : list) {
			Long deptId = ele.getDeptId();
			Dept dept = cash.get(deptId);
			if (dept==null) {
				dept = deptService.selectOneAndParentOrgById(deptId);
				cash.put(deptId, dept);
			}
			ele.setDept(dept);
		}
		return list;
	}

	/**
	 * 
	 * @param obj
	 */
	@Transactional
	public void examine(Electionman obj) {
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (obj.getState()==2&&StringUtil.isNullOrEmpty(obj.getFail())) {
			throw new RuntimeException("审核失败时需要填写原因.");
		}
		Electionman ele = electionmanDAO.selectOneById(obj.getId());
		if (ele.getState()!=0) {
			throw new RuntimeException("参选人员["+ele.getName()+"已经审核完成,不能重复审核].");
		}
		//查询是有默认投票活动
		Long vId = votingDAO.getstatusid();
		if (vId==null) {
			throw new RuntimeException("当前系统中没有默认添加审核通过人员的投票活动,请前往投票活动设置后再审核.");
		}
		try {
			int i = electionmanDAO.examine(obj);
			if (i!=1) {
				throw new RuntimeException("操作失败,请稍后再试.");
			}
			//审核成功才添加到 参选人员与投票活动中间表中
			if (obj.getState()==1) {
				Map<String,Long> map = new HashMap<>();
				map.put("eId",obj.getId());
				map.put("vId",vId);
				int j = electionmanDAO.insertEleManAndVoting(map);
				if (j!=1) {
					throw new RuntimeException("操作失败,请稍后再试.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("操作失败,请稍后再试.");
		}
	}

}