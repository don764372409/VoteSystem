package com.yuanmaxinxi.dao.votingelectionman;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.votingelectionman.Votingelectionman;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface VotingelectionmanDAO{
	int insert(Votingelectionman obj);

	int update(Votingelectionman obj);

	int delete(Long id);

	Votingelectionman selectOneById(Long id);

	List<Map<String, Object>> selectAll();

}