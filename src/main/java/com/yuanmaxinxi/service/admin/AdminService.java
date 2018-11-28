package com.yuanmaxinxi.service.admin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.admin.AdminDAO;
import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.util.MD5Util;
@Service
public class AdminService{
	@Autowired
	private AdminDAO adminDAO;
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
		return adminDAO.selectAll();
	}
	/**
	 * 登录业务
	 * @param Admin
	 */
	public Admin login(Admin admin) {
		Admin sysAdmin = adminDAO.selectOneByUsername(admin.getUsername());
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