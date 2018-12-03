package com.yuanmaxinxi.service.articletype;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.domain.organize.Organize;
import com.yuanmaxinxi.service.organize.OrganizeService;
import com.yuanmaxinxi.util.StringUtil;
import com.yuanmaxinxi.dao.articletype.ArticleTypeDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ArticleTypeService{
	@Autowired
	private ArticleTypeDAO articleTypeDAO;
	@Autowired
	private ArticleTypeService articleTypeService;
	@Transactional
	public void insert(ArticleType obj){
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("类别名称不能为空.");
		}
		int i = articleTypeDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("添加类别失败,请稍后重试.");
		}
	}


	@Transactional
	public void update(ArticleType obj){
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (StringUtil.isNullOrEmpty(obj.getName())) {
			throw new RuntimeException("类别名称不能为空.");
		}
		int i = articleTypeDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("修改类别失败,请稍后重试.");
		}
	}


	@Transactional
	public void delete(Long id){
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
		try {
			int i = articleTypeDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("删除类别失败,请稍后重试.");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("foreign key")) {
				msg = "这个类别绑定了主类别,不能进行删除哦!";
			}
			throw new RuntimeException(msg);
		}
	}


	public ArticleType selectOneById(Long id){
		return articleTypeDAO.selectOneById(id);
	}


//	public List<ArticleType> selectAll(Long pId){
//		return articleTypeDAO.selectAll(pId);
//	}
	public List<ArticleType> selectAll(Long id){
		List<ArticleType> list = articleTypeDAO.selectAll(id);
		Map<Long,ArticleType> map = new HashMap<>();
		for (ArticleType articletype : list) {
			Long atid = articletype.getArticleTypeId();
			ArticleType org = map.get(atid);
			if (org==null) {
				org = articleTypeService.selectOneById(atid);
				articletype.setArticleType(org);
			}
		}
		return list;

}
}