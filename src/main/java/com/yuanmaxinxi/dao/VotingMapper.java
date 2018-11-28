package com.yuanmaxinxi.dao;
import com.yuanmaxinxi.domain.Voting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface VotingMapper{
	int insert(Voting obj);

	int update(Voting obj);

	int delete(Long id);

	Voting selectOneById(Long id);

	List<Voting> selectAll();

}