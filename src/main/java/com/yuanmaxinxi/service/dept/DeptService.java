package com.yuanmaxinxi.service.dept;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.dept.DeptDAO;
import com.yuanmaxinxi.dao.role.RoleDAO;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.domain.role.Role;
import com.yuanmaxinxi.service.organize.OrganizeService;
import com.yuanmaxinxi.util.StringUtil;
@Service
public class DeptService{
	@Autowired
	private DeptDAO deptDAO;
	@Autowired
	private OrganizeService organizeService;
	@Autowired
	private RoleDAO roleDAO;
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
			Dept d2 = selectOneAndParentOrgById(dept.getId());
			dept.setName(d2.getName());
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
	/**
	 * 根据登录者 查询对应权限  根据全限得到数据权限   根据数据权限  得到能查的部门对象
	 * @param adminId
	 * @return
	 */
	public List<Dept> selectAllByAdminId(Long adminId){
		//装员工能查的部门对象
		List<Dept> depts = new ArrayList<>();
		List<Role> roels = roleDAO.selectAllByAdminId(adminId);
		//默认只能查当前部门
		int dataRange = 0;
		//得到角色中的最大数据权限
		for (Role role : roels) {
			if (role.getDataRange()>dataRange) {
				dataRange = role.getDataRange();
			}
		}
		//当前部门
		if (dataRange==0) {
			Dept dept = deptDAO.selectCurrentDeptByAdminId(adminId);
			depts.add(dept);
		}
		//当前当前机构
		if (dataRange==1) {
			//通过当前部门得所属机构   通过所属机构获取当前机构中的所有部门
			List<Dept> list = deptDAO.selectAllByAdminIdToOrg(adminId);
			depts.addAll(list);
		}
		//当前机构及下属机构
		if (dataRange==2) {
			//通过员工得当前机构   通过当前机构获取下级机构  再获取下级机构的部门
			Dept dept = deptDAO.selectCurrentDeptByAdminId(adminId);
			if (dept!=null) {
				List<Organize> list = organizeService.selectCurrentAndChildById(dept.getOrganizeId());
				for (Organize org : list) {
					List<Dept> ds = deptDAO.selectAllByOrganizeId(org.getId());
					depts.addAll(ds);
				}
			}
		}
		//所有部门
		if (dataRange==3) {
			List<Dept> list = deptDAO.selectAll();
			depts.addAll(list);
		}
		return depts;
	}
}