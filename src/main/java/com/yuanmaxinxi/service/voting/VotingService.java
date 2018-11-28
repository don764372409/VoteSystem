package com.yuanmaxinxi.service.voting;
import com.yuanmaxinxi.dao.voting.VotingDAO;
import com.yuanmaxinxi.domain.voting.Voting;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class VotingService{
	@Autowired
	private VotingDAO votingDAO;
	@Transactional
	public int insert(Voting obj){
		return votingDAO.insert(obj);
	}


	@Transactional
	public int update(Voting obj){
		return votingDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return votingDAO.delete(id);
	}


	public Voting selectOneById(Long id){
		return votingDAO.selectOneById(id);
	}


	public List<Voting> selectAll(){
		return votingDAO.selectAll();
	}

}