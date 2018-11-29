package com.yuanmaxinxi.service.resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.resource.ResourceDAO;
import com.yuanmaxinxi.domain.resource.Resource;
@Service
public class ResourceService{
	@Autowired
	private ResourceDAO resourceDAO;
	@Transactional
	public int insert(Resource obj){
		return resourceDAO.insert(obj);
	}


	@Transactional
	public int update(Resource obj){
		return resourceDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return resourceDAO.delete(id);
	}


	public Resource selectOneById(Long id){
		return resourceDAO.selectOneById(id);
	}


	public List<Resource> selectAll(){
		return resourceDAO.selectAll();
	}

	/**
	 * 获取当前ID对应的具有父子结构的菜单 不要按钮
	 * @param id
	 * @return
	 */
	public List<Resource> selectAllResourceByType(Long id) {
		//获取当前用户的所有角色
		List<Resource> parents = resourceDAO.selectAllParentsByAdminId(id);
		for (Resource res : parents) {
			Map<String,Long> map  = new HashMap<>();
			map.put("adminId", id);
			map.put("pId",res.getId());
			List<Resource> children = resourceDAO.selectChildrenByParentIdAndAdminId(map);
			res.setChildren(children);
		}
		return parents;
	}

}