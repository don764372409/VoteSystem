package com.yuanmaxinxi.dao.article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.yuanmaxinxi.domain.article.Article;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface ArticleDAO{
	int insert(Article obj);

	int update(Article obj);

	int delete(Long id);

	Article selectOneById(Long id);

	List<Article> selectAll(Map map);
	List<Article>  indexShow(@Param("aId")Long aId,@Param("startRecord")Integer  startRecord,@Param("pageSize")Integer  pageSize);
	int examine(Article obj);

}