package com.yuanmaxinxi.dao;
import com.yuanmaxinxi.domain.Cvrelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface CvrelationMapper{
	int insert(Cvrelation obj);

	int update(Cvrelation obj);

	int delete(Long id);

	Cvrelation selectOneById(Long id);

	List<Cvrelation> selectAll();

}