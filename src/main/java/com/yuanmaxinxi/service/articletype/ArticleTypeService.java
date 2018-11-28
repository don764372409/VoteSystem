package com.yuanmaxinxi.service.articletype;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.dao.articletype.ArticleTypeDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ArticleTypeService{
	@Autowired
	private ArticleTypeDAO articleTypeDAO;
	@Transactional
	public int insert(ArticleType obj){
		return articleTypeDAO.insert(obj);
	}


	@Transactional
	public int update(ArticleType obj){
		return articleTypeDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return articleTypeDAO.delete(id);
	}


	public ArticleType selectOneById(Long id){
		return articleTypeDAO.selectOneById(id);
	}


	public List<ArticleType> selectAll(){
		return articleTypeDAO.selectAll();
	}

}