package com.yuanmaxinxi.service.article;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.admin.AdminDAO;
import com.yuanmaxinxi.dao.article.ArticleDAO;
import com.yuanmaxinxi.domain.admin.Admin;
import com.yuanmaxinxi.domain.article.Article;
import com.yuanmaxinxi.domain.dept.Dept;
import com.yuanmaxinxi.service.dept.DeptService;
import com.yuanmaxinxi.util.StringUtil;

@Service
public class ArticleService{
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private DeptService deptService;
	@Autowired
	private AdminDAO adminDAO;
	public void insert(Article obj){
		if (StringUtil.isNullOrEmpty(obj.getImg())) {
			throw new RuntimeException("请上传文章展示图片.");
		}
		if (StringUtil.isNullOrEmpty(obj.getTitle())) {
			throw new RuntimeException("主题名称不能为空.");
		}
		if (StringUtil.isNullOrEmpty(obj.getContent())) {
			throw new RuntimeException("内容不能为空.");
		}
		if (obj.getAId()==null||obj.getAId()<1) {
			throw new RuntimeException("添加文章时必须选择类别.");
		}
		obj.setTime(new Date());
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

	public List<Article> selectAll(Map map,Long pId, Long adminId){
		List<Dept> depts = deptService.selectAllByAdminId(adminId);
		map.put("list", depts);
		map.put("pId", pId);
		List<Article> list = articleDAO.selectAll(map);
		Map<Long,Dept> cash = new HashMap<>();
		for (Article ele : list) {
			Long deptId = ele.getAdId();
			Dept dept = cash.get(deptId);
			if (dept==null) {
				dept = deptService.selectOneAndParentOrgById(deptId);
				cash.put(deptId, dept);
			}
			Admin admin = adminDAO.selectOneById(adminId);
			ele.setName(admin.getName());
		}
		return list;
	}
	//微信端  展示新闻
	public List<Article> indexShow(Long aId,Integer  startRecord,Integer  pageSize){
		return articleDAO.indexShow(aId,startRecord,pageSize);
	}
	@Transactional
	public void examine(Article obj) {
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (obj.getState()==2&&StringUtil.isNullOrEmpty(obj.getFail())) {
			throw new RuntimeException("审核失败时需要填写原因.");
		}
		Article ele = articleDAO.selectOneById(obj.getId());
		if (ele.getState()!=0) {
			throw new RuntimeException("文章["+ele.getTitle()+"已经审核完成,不能重复审核].");
		}
		int i = articleDAO.examine(obj);
		if (i!=1) {
			throw new RuntimeException("操作失败,请稍后再试.");
		}
		
	}
	}
