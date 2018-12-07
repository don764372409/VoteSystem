package com.yuanmaxinxi.service.votingman;
import com.yuanmaxinxi.domain.votingman.Votingman;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.util.IPUtils;
import com.yuanmaxinxi.dao.votingman.VotingmanDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
@Service
public class VotingmanService{
	@Autowired
	private VotingmanDAO votingmanDAO;
	@Transactional
	public int insert(Votingman obj){
		return votingmanDAO.insert(obj);
	}


	@Transactional
	public int update(Votingman obj){
		return votingmanDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return votingmanDAO.delete(id);
	}


	public Votingman selectOneById(Long id){
		return votingmanDAO.selectOneById(id);
	}


	public List<Votingman> selectAll(){
		return votingmanDAO.selectAll();
	}
	
	public int selectwechatonly(String openid,Long id ) {
		return votingmanDAO.selectwechatonly(openid,id);
	}

}