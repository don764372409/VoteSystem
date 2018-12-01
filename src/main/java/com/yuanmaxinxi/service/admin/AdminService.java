package com.yuanmaxinxi.service.admin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.admin.AdminDAO;
import com.yuanmaxinxi.dao.dept.DeptDAO;
import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.util.MD5Util;
@Service
public class AdminService{
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private DeptDAO deptDAO;
	@Transactional
	public int insert(Admin obj){
		return adminDAO.insert(obj);
	}


	@Transactional
	public int update(Admin obj){
		return adminDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return adminDAO.delete(id);
	}


	public Admin selectOneById(Long id){
		return adminDAO.selectOneById(id);
	}


	public List<Admin> selectAll(){
		List<Admin> list = adminDAO.selectAll();
		Map<Long,Dept> cash = new HashMap<>();
		for (Admin admin : list) {
			Long deptId = admin.getDeptId();
			Dept dept = cash.get(deptId);
			if (dept == null) {
				dept = deptDAO.selectOneById(deptId);
				cash.put(deptId, dept);
			}
			admin.setDept(dept);
		}
		return list;
	}
	/**
	 * 登录业务
	 * @param Admin
	 */
	public Admin login(Admin admin) {
		Admin sysAdmin = adminDAO.selectOneByName(admin.getName());
		if (sysAdmin==null) {
			throw new RuntimeException("账号不存在.");
		}
		String password = MD5Util.encode(admin.getPassword());
		if (!sysAdmin.getPassword().equals(password)) {
			throw new RuntimeException("密码错误.");
		}
		return sysAdmin;
	}

}