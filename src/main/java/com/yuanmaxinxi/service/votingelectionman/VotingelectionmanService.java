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
	public int updatenewnumber(Long id) {
		return votingelectionmanDAO.updatenewnumber(id);
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
	public List<Map<String, Object>> getstatistics(Long vid){
		return votingelectionmanDAO.getstatistics(vid);
	}
	
	@Transactional
	public List<Map<String, Object>> getwechatelist(){
		return votingelectionmanDAO.getwechatelist();
	}
	@Transactional
	public List<Map<String, Object>> chagewechatvlist(Long deptId,String type,String name){
		return votingelectionmanDAO.chagewechatvlist(deptId,type,name);
	}
	public List<Map<String, Object>> getallorganize(){
		return votingelectionmanDAO.getallorganize();
	}
	public List<Map<String, Object>> getalldept(Long id){
		return votingelectionmanDAO.getalldept(id);
	}
	public List<Map<String, Object>> getallvoter(Long id){
		return votingelectionmanDAO.getallvoter(id);
	}
	
}