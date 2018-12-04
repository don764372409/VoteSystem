package com.yuanmaxinxi.service.votingelectionman;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.yuanmaxinxi.dao.votingelectionman.VotingelectionmanDAO;
import com.yuanmaxinxi.domain.votingelectionman.Votingelectionman;
import java.util.List;
import java.util.Map;

@Service
public class VotingelectionmanService{
	@Autowired
	private VotingelectionmanDAO votingelectionmanDAO;
	@Transactional
	public int insert(Votingelectionman obj){
		return votingelectionmanDAO.insert(obj);
	}


	@Transactional
	public int update(Votingelectionman obj){
		return votingelectionmanDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return votingelectionmanDAO.delete(id);
	}

	@Transactional
	public Votingelectionman selectOneById(Long id){
		return votingelectionmanDAO.selectOneById(id);
	}

	@Transactional
	public List<Map<String, Object>> selectAll(){
		return votingelectionmanDAO.selectAll();
	}
	@Transactional
	public List<Map<String, Object>> getstatistics(){
		return votingelectionmanDAO.getstatistics();
	}
	
}