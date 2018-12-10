package com.yuanmaxinxi.dao.voting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.voting.Voting;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface VotingDAO{
	int insert(Voting obj);

	int update(Voting obj);

	int delete(Long id);

	Voting selectOneById(Long id);

	List<Voting> selectAll(Map map);
	
	Long getstatusid();
	
	int updatestatus(Long id);
	
	List<Voting> selectvotinglist();
	
	int upvist();
	
	String getvrule();
	
}