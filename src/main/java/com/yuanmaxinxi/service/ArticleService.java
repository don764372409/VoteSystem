package com.yuanmaxinxi.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.ArticleMapper;
import com.yuanmaxinxi.domain.Article;

import java.util.List;
@Service
public class ArticleService{
	@Autowired
	private ArticleMapper articleMapper;
	@Transactional
	public int insert(Article obj){
		return articleMapper.insert(obj);
	}


	@Transactional
	public int update(Article obj){
		return articleMapper.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return articleMapper.delete(id);
	}


	public Article selectOneById(Long id){
		return articleMapper.selectOneById(id);
	}


	public List<Article> selectAll(){
		return articleMapper.selectAll();
	}

}