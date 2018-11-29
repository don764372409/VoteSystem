package com.yuanmaxinxi.dao.candidate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.candidate.Candidate;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface CandidateDAO{
	int insert(Candidate obj);

	int update(Candidate obj);

	int delete(Long id);

	Candidate selectOneById(Long id);

	List<Candidate> selectAll(Map map);

	int countall(Map map);

}