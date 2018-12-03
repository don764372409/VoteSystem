package com.yuanmaxinxi.service.electionman;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.yuanmaxinxi.dao.electionman.ElectionmanDAO;
import com.yuanmaxinxi.domain.electionman.Electionman;
import com.yuanmaxinxi.util.StringUtil;

import java.util.List;
import java.util.Map;


@Service
public class ElectionmanService{
	@Autowired
	private ElectionmanDAO electionmanDAO;
	@Transactional
	public void insert(Electionman obj){
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("预选人名字不能为空.");
		}
		if (obj.getDeptId()==null||obj.getDeptId()<1) {
			throw new RuntimeException("添加预选人时必须选择机构.");
		}
		int i = electionmanDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("添加失败,请稍后重试.");
		}
	}


	@Transactional
	public void update(Electionman obj){
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("预选人名字不能为空.");
		}
		if (obj.getDeptId()==null||obj.getDeptId()<1) {
			throw new RuntimeException("修改预选人时必须选择部门.");
		}
		int i = electionmanDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("修改预选人失败,请稍后重试.");
		}
	}


	@Transactional
	public void delete(Long id){
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
			int i = electionmanDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("删除失败,请稍后重试.");
			}
	}


	public Electionman selectOneById(Long id){
		return electionmanDAO.selectOneById(id);
	}


	public List<Electionman> selectAll( Map map){
		return electionmanDAO.selectAll(map);
	}

}