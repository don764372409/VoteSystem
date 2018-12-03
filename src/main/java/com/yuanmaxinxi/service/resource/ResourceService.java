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

	/**
	 * 获取所有具有父子结构的菜单   包括按钮
	 * @return
	 */
	public List<Resource> getAllResources() {
		//获取父节点
		List<Resource> parents = resourceDAO.selectAllParents();
		for (Resource res : parents) {
			//获取子节点
			List<Resource> children = resourceDAO.selectChildrenByParentId(res.getId());
			res.setChildren(children);
			for (Resource cd : children) {
				//获取按钮
				List<Resource> btns = resourceDAO.selectChildrenByParentId(cd.getId());
				cd.setChildren(btns);
			}
		}
		return parents;
	}

	/**
	 * 获取角色的菜单和按钮 资源对象 ID
	 * @param roleId
	 * @return
	 */
	public List<Long> getAllResourceByRole(Long roleId) {
		return resourceDAO.getAllResourceByRole(roleId);
	}

}