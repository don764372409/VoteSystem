package com.yuanmaxinxi.service;
import com.yuanmaxinxi.domain.Candidate;
import com.yuanmaxinxi.dao.CandidateMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CandidateService{
	@Autowired
	private CandidateMapper candidateDAO;
	@Transactional
	public int insert(Candidate obj){
		return candidateDAO.insert(obj);
	}


	@Transactional
	public int update(Candidate obj){
		return candidateDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return candidateDAO.delete(id);
	}


	public Candidate selectOneById(Long id){
		return candidateDAO.selectOneById(id);
	}


	public List<Candidate> selectAll(){
		return candidateDAO.selectAll();
	}

}