package com.yuanmaxinxi.service;
import com.yuanmaxinxi.domain.Voting;
import com.yuanmaxinxi.dao.VotingMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class VotingService{
	@Autowired
	private VotingMapper votingDAO;
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