package com.yuanmaxinxi.service.dept;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.dept.DeptDAO;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.service.organize.OrganizeService;
import com.yuanmaxinxi.util.StringUtil;
@Service
public class DeptService{
	@Autowired
	private DeptDAO deptDAO;
	@Autowired
	private OrganizeService organizeService;
	@Transactional
	public void insert(Dept obj){
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("部门名称不能为空.");
		}
		if (obj.getOrganizeId()==null||obj.getOrganizeId()<1) {
			throw new RuntimeException("添加部门时必须选择机构.");
		}
		int i = deptDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("添加部门失败,请稍后重试.");
		}
	}


	@Transactional
	public void update(Dept obj){
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("部门名称不能为空.");
		}
		if (obj.getOrganizeId()==null||obj.getOrganizeId()<1) {
			throw new RuntimeException("修改部门时必须选择机构.");
		}
		int i = deptDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("修改部门失败,请稍后重试.");
		}
	}


	@Transactional
	public void delete(Long id){
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
		try {
			int i = deptDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("删除部门失败,请稍后重试.");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("foreign key")) {
				msg = "这个部门绑定了管理员,不能进行删除哦!";
			}
			throw new RuntimeException(msg);
		}
	}


	public Dept selectOneById(Long id){
		return deptDAO.selectOneById(id);
	}


	public List<Dept> selectAll(){
		List<Dept> list = deptDAO.selectAll();
		Map<Long,Organize> map = new HashMap<>();
		for (Dept dept : list) {
			Long orgId = dept.getOrganizeId();
			Organize org = map.get(orgId);
			if (org==null) {
				org = organizeService.selectOneById(orgId);
				map.put(orgId, org);
			}
			dept.setOrganize(org);
		}
		return list;
	}

	/**
	 * 查询部门和部门所属上级机构  机构可能有无限级
	 * @param deptId
	 * @return
	 */
	public Dept selectOneAndParentOrgById(Long deptId) {
		Dept dept = selectOneById(deptId);
		if (dept!=null) {
			String name = organizeService.coverDeptName(dept.getName(),dept.getOrganizeId());
			dept.setName(name);
		}
		return dept;
	}
	
}