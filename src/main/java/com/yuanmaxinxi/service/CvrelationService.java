package com.yuanmaxinxi.service;
import com.yuanmaxinxi.domain.Cvrelation;
import com.yuanmaxinxi.dao.CvrelationMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CvrelationService{
	@Autowired
	private CvrelationMapper cvrelationDAO;
	@Transactional
	public int insert(Cvrelation obj){
		return cvrelationDAO.insert(obj);
	}


	@Transactional
	public int update(Cvrelation obj){
		return cvrelationDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return cvrelationDAO.delete(id);
	}


	public Cvrelation selectOneById(Long id){
		return cvrelationDAO.selectOneById(id);
	}


	public List<Cvrelation> selectAll(){
		return cvrelationDAO.selectAll();
	}

}