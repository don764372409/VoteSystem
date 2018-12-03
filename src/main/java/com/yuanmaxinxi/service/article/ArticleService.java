package com.yuanmaxinxi.service.article;
import com.yuanmaxinxi.domain.article.Article;
import com.yuanmaxinxi.dao.article.ArticleDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ArticleService{
	@Autowired
	private ArticleDAO articleDAO;
	@Transactional
	public int insert(Article obj){
		return articleDAO.insert(obj);
	}


	@Transactional
	public int update(Article obj){
		return articleDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return articleDAO.delete(id);
	}


	public Article selectOneById(Long id){
		return articleDAO.selectOneById(id);
	}


	public List<Article> selectAll(){
		return articleDAO.selectAll();
	}

}