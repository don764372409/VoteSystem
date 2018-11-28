package com.yuanmaxinxi.dao;
import com.yuanmaxinxi.domain.ArticleType;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface ArticleTypeMapper{
	int insert(ArticleType obj);

	int update(ArticleType obj);

	int delete(Long id);

	ArticleType selectOneById(Long id);

	List<ArticleType> selectAll();

}