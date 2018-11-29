package com.yuanmaxinxi.service.candidate;
import com.yuanmaxinxi.dao.candidate.CandidateDAO;
import com.yuanmaxinxi.domain.candidate.Candidate;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
@Service
public class CandidateService{
	@Autowired
	private CandidateDAO candidateDAO;
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


	public List<Candidate> selectAll(Map map){
		return candidateDAO.selectAll(map);
	}
	
	public int countall(Map map) {
		return candidateDAO.countall(map);
	}

}