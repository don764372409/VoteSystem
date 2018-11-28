package com.yuanmaxinxi.service.resource;
import com.yuanmaxinxi.domain.resource.Resource;
import com.yuanmaxinxi.dao.resource.ResourceDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
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

}