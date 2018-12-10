package com.yuanmaxinxi.dao.votingelectionman;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.votingelectionman.Votingelectionman;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface VotingelectionmanDAO{
	int insert(Votingelectionman obj);

	int update(Votingelectionman obj);

	int updatenewnumber(Long id);
	
	int delete(Long id);

	Votingelectionman selectOneById(Long id);

	List<Map<String, Object>> selectAll();
	
	List<Map<String, Object>> getstatistics(@Param("vid") Long vid);
	
	List<Map<String, Object>> getwechatelist();
	List<Map<String, Object>> getwechatelists();
	List<Map<String, Object>>getallorganize();
	List<Map<String, Object>>getalldept(Long id);
	List<Map<String, Object>>getallvoter(Long id);
	
	List<Map<String, Object>> chagewechatvlist(@Param("deptId")Long deptId,@Param("type")String type,@Param("name")String name);

	Long gettotle();

}