package com.yuanmaxinxi.dao.votingman;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

	int selectwechatonly(@Param("openid") String openid,@Param("id") Long id);
	
	int selectwechattoday(@Param("openid") String openid);
	
}