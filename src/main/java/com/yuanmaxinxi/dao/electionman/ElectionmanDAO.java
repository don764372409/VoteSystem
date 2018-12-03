package com.yuanmaxinxi.dao.electionman;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.electionman.Electionman;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ElectionmanDAO{
	int insert(Electionman obj);

	int update(Electionman obj);

	int delete(Long id);

	Electionman selectOneById(Long id);

	List<Electionman> selectAll(Map map);

}