package com.yuanmaxinxi.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.ArticleTypeMapper;
import com.yuanmaxinxi.domain.ArticleType;

import java.util.List;
@Service
public class ArticleTypeService{
	@Autowired
	private ArticleTypeMapper articleTypeMapper;
	@Transactional
	public int insert(ArticleType obj){
		return articleTypeMapper.insert(obj);
	}


	@Transactional
	public int update(ArticleType obj){
		return articleTypeMapper.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return articleTypeMapper.delete(id);
	}


	public ArticleType selectOneById(Long id){
		return articleTypeMapper.selectOneById(id);
	}


	public List<ArticleType> selectAll(){
		return articleTypeMapper.selectAll();
	}

}