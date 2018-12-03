package com.yuanmaxinxi.dao.votingman;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.yuanmaxinxi.domain.votingman.Votingman;

import java.util.List;
@Mapper
@Repository
public interface VotingmanDAO{
	int insert(Votingman obj);

	int update(Votingman obj);

	int delete(Long id);

	Votingman selectOneById(Long id);

	List<Votingman> selectAll();

}