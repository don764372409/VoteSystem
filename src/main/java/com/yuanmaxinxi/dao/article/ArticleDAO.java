package com.yuanmaxinxi.dao.article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.article.Article;
import com.yuanmaxinxi.domain.electionman.Electionman;

import java.util.List;
@Mapper
@Repository
public interface ArticleDAO{
	int insert(Article obj);

	int update(Article obj);

	int delete(Long id);

	Article selectOneById(Long id);

	List<Article> selectAll(Long pId);
	int examine(Article obj);

}