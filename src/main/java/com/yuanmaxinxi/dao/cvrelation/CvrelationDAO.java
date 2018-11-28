package com.yuanmaxinxi.dao.cvrelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.cvrelation.Cvrelation;

import java.util.List;
@Mapper
@Repository
public interface CvrelationDAO{
	int insert(Cvrelation obj);

	int update(Cvrelation obj);

	int delete(Long id);

	Cvrelation selectOneById(Long id);

	List<Cvrelation> selectAll();

}