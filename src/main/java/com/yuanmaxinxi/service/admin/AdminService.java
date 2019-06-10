package com.yuanmaxinxi.service.admin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.admin.AdminDAO;
import com.yuanmaxinxi.dao.role.RoleDAO;
import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.role.Role;
import com.yuanmaxinxi.service.dept.DeptService;
import com.yuanmaxinxi.util.MD5Util;
import com.yuanmaxinxi.util.StringUtil;
@Service
public class AdminService{
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleDAO roleDAO;
	@Transactional
	public void insert(Admin obj, Long roleId){
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("管理员姓名不能为空.");
		}
		if (StringUtil.isNullOrEmpty(obj.getPhone())) {
			throw new RuntimeException("管理员电话不能为空.");
		}
		if (obj.getDeptId()==null||obj.getDeptId()<0) {
			throw new RuntimeException("管理员所属部门不能为空.");
		}
		if (roleId==null||roleId<0) {
			throw new RuntimeException("管理员拥有角色不能为空.");
		}
		String password = MD5Util.encode("88888888");
		obj.setPassword(password);
		
		int i =  adminDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("管理员添加失败,请刷新重试.");
		}
		Map<String,Long> map = new HashMap<>();
		map.put("adminId", obj.getId());
		map.put("roleId", roleId);
		int j = adminDAO.insertAdminAndRole(map);
		if (j!=1) {
			throw new RuntimeException("管理员添加失败,请刷新重试.");
		}
	}


	@Transactional
	public void update(Admin obj, Long roleId){
		if (obj.getId()==null) {
			throw new RuntimeException("非法访问.");
		}
		if (obj.getId()==1L) {
			throw new RuntimeException("不能修改系统内置超级管理员.");
		}
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("管理员姓名不能为空.");
		}
		if (StringUtil.isNullOrEmpty(obj.getPhone())) {
			throw new RuntimeException("管理员电话不能为空.");
		}
		if (obj.getDeptId()==null||obj.getDeptId()<0) {
			throw new RuntimeException("管理员所属部门不能为空.");
		}
		if (roleId==null||roleId<0) {
			throw new RuntimeException("管理员拥有角色不能为空.");
		}
		int i =  adminDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("管理员修改失败,请刷新重试.");
		}
		//先删除角色中间表数据
		try {
			adminDAO.deleteAdminAndRoleByAdminId(obj.getId());
			
			//再添加
			Map<String,Long> map = new HashMap<>();
			map.put("adminId", obj.getId());
			map.put("roleId", roleId);
			System.err.println(map);
			int j = adminDAO.insertAdminAndRole(map);
			if (j!=1) {
				throw new RuntimeException("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("管理员修改失败,请刷新重试.");
		}
	}


	@Transactional
	public void delete(Long id){
		if (id==null) {
			throw new RuntimeException("非法访问.");
		}
		if (id==1L) {
			throw new RuntimeException("不能删除系统内置超级管理员.");
		}
		try {
			int i = adminDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("系统管理员删除失败,请稍后重试.");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("foreign key")) {
				msg = "这个管理员拥有绑定了其他数据(角色,部门),不能进行删除哦!";
			}
			throw new RuntimeException(msg);
		}
	}


	public Admin selectOneById(Long id){
		Admin admin = adminDAO.selectOneById(id);
//		Dept dept = deptService.selectOneAndParentOrgById(admin.getDeptId());
//		admin.setDept(dept);
//		List<Role> roles = roleDAO.selectAllByAdminId(id);
//		admin.setRole(roles.get(0));
		return admin;
	}


	public List<Admin> selectAll(){
		List<Admin> list = adminDAO.selectAll();
		//封装部门
		Map<Long,Dept> cash = new HashMap<>();
		for (Admin admin : list) {
			Long deptId = admin.getDeptId();
			Dept dept = cash.get(deptId);
			if (dept == null) {
				dept = deptService.selectOneAndParentOrgById(deptId);
				cash.put(deptId, dept);
			}
			admin.setDept(dept);
			//封装角色
			List<Role> roles = roleDAO.selectAllByAdminId(admin.getId());
			admin.setRoles(roles);
		}
		return list;
	}
	/**
	 * 登录业务
	 * @param Admin
	 */
	public Admin login(Admin admin) {
		try {
			Admin sysAdmin = adminDAO.selectOneByName(admin.getName());
			if (sysAdmin==null) {
				throw new RuntimeException("账号不存在.");
			}
			String password = MD5Util.encode(admin.getPassword());
			if (!sysAdmin.getPassword().equals(password)) {
				throw new RuntimeException("密码错误.");
			}
			return sysAdmin;
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("Communications link failure")) {
				msg = "登录失败,请刷新页面再试.";
			}
			throw new RuntimeException(msg);
		}
	}
	/**
	 * 修改密码
	 * @param loginAdmin
	 * @param obj
	 * @return
	 */
	public Admin editPassword(Admin loginAdmin, Admin obj,String confPassword) {
		if (StringUtil.isNullOrEmpty(obj.getPassword())) {
			throw new RuntimeException("原密码不能为空.");
		}
		if (StringUtil.isNullOrEmpty(confPassword)) {
			throw new RuntimeException("新密码不能为空.");
		}
		//用户输的原密码加密
		String md5Password = MD5Util.encode(obj.getPassword());
		if (!loginAdmin.getPassword().equals(md5Password)) {
			throw new RuntimeException("原密码错误.");
		}
		//用户输的新密码加密
		confPassword = MD5Util.encode(confPassword);
		if (confPassword.equals(md5Password)) {
			throw new RuntimeException("新密码不能与原密码相同.");
		}
		loginAdmin.setPassword(confPassword);
		int i = adminDAO.updatePassword(loginAdmin);
		if (i!=1) {
			throw new RuntimeException("密码修改失败,请稍后重试.");
		}
		return loginAdmin;
	}


	public void resetPassword(Long id) {
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
		Admin admin = new Admin();
		admin.setId(id);
		String password = MD5Util.encode("88888888");
		admin.setPassword(password);
		int i = adminDAO.updatePassword(admin);
		if (i!=1) {
			throw new RuntimeException("密码修改失败,请稍后重试.");
		}
	}
}