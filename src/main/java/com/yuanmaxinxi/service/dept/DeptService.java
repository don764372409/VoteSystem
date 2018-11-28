package com.yuanmaxinxi.service.dept;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.dao.dept.DeptDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class DeptService{
	@Autowired
	private DeptDAO deptDAO;
	@Transactional
	public int insert(Dept obj){
		return deptDAO.insert(obj);
	}


	@Transactional
	public int update(Dept obj){
		return deptDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return deptDAO.delete(id);
	}


	public Dept selectOneById(Long id){
		return deptDAO.selectOneById(id);
	}


	public List<Dept> selectAll(){
		return deptDAO.selectAll();
	}

}