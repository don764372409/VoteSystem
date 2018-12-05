package com.yuanmaxinxi.service.article;
import com.yuanmaxinxi.domain.article.Article;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.util.StringUtil;
import com.yuanmaxinxi.dao.article.ArticleDAO;
import com.yuanmaxinxi.dao.articletype.ArticleTypeDAO;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ArticleService{
	@Autowired
	private ArticleDAO articleDAO;
	public void insert(Article obj){
		if (StringUtil.isNullOrEmpty(obj.getTitle())) {
			throw new RuntimeException("主题名称不能为空.");
		}
		if (StringUtil.isNullOrEmpty(obj.getContent())) {
			throw new RuntimeException("内容不能为空.");
		}
		if (obj.getAId()==null||obj.getAId()<1) {
			throw new RuntimeException("添加文章时必须选择类别.");
		}
		int i = articleDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("添加文章失败,请稍后重试.");
		}
	}


	@Transactional
	public void update(Article obj){
		if (StringUtil.isNullOrEmpty(obj.getTitle())) {
			throw new RuntimeException("主题名称不能为空.");
		}
		if (StringUtil.isNullOrEmpty(obj.getContent())) {
			throw new RuntimeException("内容不能为空.");
		}
		if (obj.getAId()==null||obj.getAId()<1) {
			throw new RuntimeException("修改文章时必须选择类别.");
		}
		int i = articleDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("修改文章失败,请稍后重试.");
		}
	}


	@Transactional
	public void delete(Long id){
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
		try {
			int i = articleDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("删除文章失败,请稍后重试.");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("foreign key")) {
				msg = "这个文章绑定了类别,不能进行删除哦!";
			}
			throw new RuntimeException(msg);
		}
	}


	public Article selectOneById(Long id){
		return articleDAO.selectOneById(id);
	}

	public List<Article> selectAll(Long pId){
		return  articleDAO.selectAll(pId);
	}
	}
