package com.yuanmaxinxi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.Article;

import java.util.List;
@Mapper
@Repository
public interface ArticleMapper{
	int insert(Article obj);

	int update(Article obj);

	int delete(Long id);

	Article selectOneById(Long id);

	List<Article> selectAll();

}