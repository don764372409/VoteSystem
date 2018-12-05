package com.yuanmaxinxi.dao.articletype;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface ArticleTypeDAO{
	int insert(ArticleType obj);

	int update(ArticleType obj);
	int delete(Long id);
	ArticleType selectOneById(Long id);
	List<ArticleType> selectAll(Long pid);
	List<ArticleType> selectAllParents(Long pId);

}