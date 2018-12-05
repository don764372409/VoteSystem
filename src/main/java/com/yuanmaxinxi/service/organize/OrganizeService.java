package com.yuanmaxinxi.service.organize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.dept.DeptDAO;
import com.yuanmaxinxi.dao.organize.OrganizeDAO;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.util.StringUtil;
@Service
public class OrganizeService{
	@Autowired
	private OrganizeDAO organizeDAO;
	@Autowired
	private DeptDAO deptDAO;
	@Transactional
	public void insert(Organize obj){
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("请输入机构名称.");
		}
		if (obj.getpId()==null||obj.getpId()==-1) {
			obj.setpId(null);
		}
		int i = organizeDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("机构添加失败,请稍后再试.");
		}
	}


	@Transactional
	public void update(Organize obj){
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("请输入机构名称.");
		}
		if (obj.getpId()==-1) {
			obj.setpId(null);
		}
		int i = organizeDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("机构修改失败,请稍后再试.");
		}
	}


	@Transactional
	public void delete(Long id){
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
		try {
			int i = organizeDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("机构删除失败,请稍后再试.");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("foreign key")) {
				msg = "这个机构拥有下属机构,不能进行删除哦!";
			}
			throw new RuntimeException(msg);
		}
	}


	public Organize selectOneById(Long id){
		return organizeDAO.selectOneById(id);
	}


	public List<Organize> selectAll(){
		List<Organize> list = organizeDAO.selectAll();
		Map<Long,Organize> map = new HashMap<>();
		for (Organize org : list) {
			Long pId = org.getpId();
			Organize parent = map.get(pId);
			if (parent==null) {
				parent = selectOneById(pId);
				map.put(pId, parent);
			}
			org.setParent(parent);
		}
		return list;
	}
	//获取所有机构 树形
	public List<Organize> selectOrgAndeDeptToTree() {
		List<Organize> list = organizeDAO.selectAllParents();
		addChildrenAndDepts(list);
		return list;
	}
	/**
	 * 获取当前机构和下级机构
	 * @return
	 */
	public List<Organize> selectCurrentAndChildById(Long id) {
		List<Organize> list = new ArrayList<>();
		Organize org = selectOneById(id);
		list.add(org);
		selectChildByParentId(org.getId(),list);
		return list;
	}
	/**
	 * 根据父级机构id  查询子级机构
	 * @param id
	 * @param list 
	 * @return
	 */
	private void selectChildByParentId(Long id, List<Organize> list) {
		List<Organize> children = organizeDAO.selectChildrenByPId(id);
		list.addAll(children);
		for (Organize org : children) {
			selectChildByParentId(org.getId(), list);
		}
	}


	private void addChildrenAndDepts(List<Organize> list) {
		for (Organize org : list) {
			//查儿子
			List<Organize> children = organizeDAO.selectChildrenByPId(org.getId());
			org.setChildren(children);
			//查部门
			List<Dept> depts = deptDAO.selectAllByOrganizeId(org.getId());
			org.setDepts(depts);
			addChildrenAndDepts(children);
		}
	}
	/**
	 * 封装具有层级关系的部门名称
	 * @param name
	 * @param id
	 * @return
	 */
	public String coverDeptName(String name, Long id) {
		Organize org = selectOneById(id);
		if (org!=null) {
			name = org.getName()+":"+name;
			name = coverDeptName(name, org.getpId());
		}
		return name;
	}
}