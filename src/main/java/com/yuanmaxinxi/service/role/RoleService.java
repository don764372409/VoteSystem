package com.yuanmaxinxi.service.role;
import com.yuanmaxinxi.domain.role.Role;
import com.yuanmaxinxi.dao.role.RoleDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class RoleService{
	@Autowired
	private RoleDAO roleDAO;
	@Transactional
	public int insert(Role obj){
		return roleDAO.insert(obj);
	}


	@Transactional
	public int update(Role obj){
		return roleDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return roleDAO.delete(id);
	}


	public Role selectOneById(Long id){
		return roleDAO.selectOneById(id);
	}


	public List<Role> selectAll(){
		return roleDAO.selectAll();
	}

}