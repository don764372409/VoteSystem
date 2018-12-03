package com.yuanmaxinxi.service.role;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.role.RoleDAO;
import com.yuanmaxinxi.domain.role.Role;
import com.yuanmaxinxi.util.StringUtil;
@Service
public class RoleService{
	@Autowired
	private RoleDAO roleDAO;
	@Transactional
	public void insert(Role obj,Long[] ids){
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("请输入角色名称.");
		}
		if (obj.getDataRange()<0||obj.getDataRange()>3) {
			throw new RuntimeException("非法访问.");
		}
		int i = roleDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("角色添加失败,请稍后再试.");
		}
		for (Long rId : ids) {
			Map<String,Long> map = new HashMap<>();
			map.put("roleId", obj.getId());
			map.put("resourceId", rId);
			int row = roleDAO.insertRoleAndResource(map);
			if (row!=1) {
				throw new RuntimeException("角色资源添加失败,请稍后重试.");
			}
		}
		
	}


	@Transactional
	public void update(Role obj){
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (obj.getId()==1L) {
			throw new RuntimeException("无法修改超级管理员角色.");
		}
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("请输入角色名称.");
		}
		int i = roleDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("角色修改失败,请稍后再试.");
		}
	}


	@Transactional
	public void delete(Long id){
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
		if (id==1L) {
			throw new RuntimeException("无法删除超级管理员角色.");
		}
		try {
			int i = roleDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("角色删除失败,请稍后再试.");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("foreign key")) {
				msg = "这个角色绑定了其他数据,不能删除.";
			}
			throw new RuntimeException(msg);
		}
	}


	public Role selectOneById(Long id){
		return roleDAO.selectOneById(id);
	}


	public List<Role> selectAll(){
		return roleDAO.selectAll();
	}

}