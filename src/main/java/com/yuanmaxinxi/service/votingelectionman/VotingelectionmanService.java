package com.yuanmaxinxi.service.votingelectionman;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.yuanmaxinxi.dao.votingelectionman.VotingelectionmanDAO;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.electionman.Electionman;
import com.yuanmaxinxi.domain.votingelectionman.Votingelectionman;
import com.yuanmaxinxi.service.dept.DeptService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VotingelectionmanService{
	@Autowired
	private VotingelectionmanDAO votingelectionmanDAO;
	@Autowired
	private DeptService deptService;
	
	@Transactional
	public int insert(Votingelectionman obj){
		return votingelectionmanDAO.insert(obj);
	}


	@Transactional
	public int update(Votingelectionman obj){
		return votingelectionmanDAO.update(obj);
	}
	
	@Transactional
	public int updatenewnumber(Long id) {
		return votingelectionmanDAO.updatenewnumber(id);
	}

	@Transactional
	public int delete(Long id){
		return votingelectionmanDAO.delete(id);
	}
	
	public Long selectvid(){
		return votingelectionmanDAO.selectvid();
	}
	
	@Transactional
	public int insertve(Long id,Long vid){
		return votingelectionmanDAO.insertve(id,vid);
	}
	
	public int ifcz(Long id,Long vid){
		return votingelectionmanDAO.ifcz(id,vid);
	}
	
	@Transactional
	public Votingelectionman selectOneById(Long id){
		return votingelectionmanDAO.selectOneById(id);
	}

	@Transactional
	public List<Map<String, Object>> selectAll(Long adminId){
		//获取能查那些部门的参选人员
				List<Dept> depts = deptService.selectAllByAdminId(adminId);
				List<Map<String, Object>> list = votingelectionmanDAO.selectAll(depts);
				Map<Long,Dept> cash = new HashMap<>();
				for (Map<String, Object> ele : list) {
					Long deptId = (Long) ele.get("deptId");
					Dept dept = cash.get(deptId);
					if (dept==null) {
						dept = deptService.selectOneAndParentOrgById(deptId);
						cash.put(deptId, dept);
					}
					ele.put("dept", dept);
				}
				return list;
	}
	@Transactional
	public List<Map<String, Object>> getstatistics(Long vid){
		return votingelectionmanDAO.getstatistics(vid);
	}
	
	@Transactional
	public List<Map<String, Object>> getwechatelist(){
		return votingelectionmanDAO.getwechatelist();
	}
	@Transactional
	public List<Map<String, Object>> getwechatelists(){
		return votingelectionmanDAO.getwechatelists();
	}
	@Transactional
	public List<Map<String, Object>> chagewechatvlist(Long deptId,String type,String name){
		return votingelectionmanDAO.chagewechatvlist(deptId,type,name);
	}
	public List<Map<String, Object>> getallorganize(){
		return votingelectionmanDAO.getallorganize();
	}
	public List<Map<String, Object>> getalldept(Long id){
		return votingelectionmanDAO.getalldept(id);
	}
	public List<Map<String, Object>> getallvoter(Long id){
		return votingelectionmanDAO.getallvoter(id);
	}
	public Long gettotle() {
		return votingelectionmanDAO.gettotle();
	}
	
}