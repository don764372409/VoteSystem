package com.yuanmaxinxi.dao.candidate;
import com.yuanmaxinxi.domain.Candidate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface CandidateDAO{
	int insert(Candidate obj);

	int update(Candidate obj);

	int delete(Long id);

	Candidate selectOneById(Long id);

	List<Candidate> selectAll();

}