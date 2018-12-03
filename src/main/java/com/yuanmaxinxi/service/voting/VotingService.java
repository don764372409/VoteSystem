package com.yuanmaxinxi.service.voting;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.yuanmaxinxi.dao.voting.VotingDAO;
import com.yuanmaxinxi.domain.voting.Voting;
import com.yuanmaxinxi.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Service
public class VotingService{
	@Autowired
	private VotingDAO votingDAO;
	
	@Transactional
	public void insert(Voting obj,HttpServletRequest request){
		if (StringUtil.isNullOrEmpty(obj.getTitle())) {
			throw new RuntimeException("标题不能为空.");
		}
		if (obj.getRule()==null||StringUtil.isNullOrEmpty(obj.getRule())) {
			throw new RuntimeException("活动规则不能为空");
		}
		if (request.getParameter("starttimes")==null || "".equals(request.getParameter("starttimes"))) {
			throw new RuntimeException("开始时间不能为空");
		}else {
			obj.setStarttime(StringUtil.strToDate(request.getParameter("starttimes")));
		}
		if (request.getParameter("endtimes")==null || "".equals(request.getParameter("endtimes"))) {
			throw new RuntimeException("结束时间不能为空");
		}else {
			obj.setEndtime(StringUtil.strToDate(request.getParameter("endtimes")));
		}
		int i = votingDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("添加失败,请稍后重试.");
		}
	}


	@Transactional
	public int update(Voting obj,HttpServletRequest request){
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (StringUtil.isNullOrEmpty(obj.getTitle())) {
			throw new RuntimeException("标题不能为空.");
		}
		if (obj.getRule()==null||StringUtil.isNullOrEmpty(obj.getRule())) {
			throw new RuntimeException("活动规则不能为空");
		}
		if (request.getParameter("starttimes")==null || "".equals(request.getParameter("starttimes"))) {
			throw new RuntimeException("开始时间不能为空");
		}else {
			obj.setStarttime(StringUtil.strToDate(request.getParameter("starttimes")));
		}
		if (request.getParameter("endtimes")==null || "".equals(request.getParameter("endtimes"))) {
			throw new RuntimeException("结束时间不能为空");
		}else {
			obj.setEndtime(StringUtil.strToDate(request.getParameter("endtimes")));
		}
		int i = votingDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("修改失败,请稍后重试.");
		}
		return votingDAO.update(obj);
	}


	@Transactional
	public void delete(Long id){
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
			int i = votingDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("删除失败,请稍后重试.");
			}
	}


	public Voting selectOneById(Long id){
		return votingDAO.selectOneById(id);
	}


	public List<Voting> selectAll(Map map){
		return votingDAO.selectAll(map);
	}

}