package com.yuanmaxinxi.service.admin;
import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.dao.admin.AdminDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
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

}