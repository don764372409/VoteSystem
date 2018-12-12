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
	
	/**
	 * 
	* @Title: insert
	* @Description: TODO(添加投票活动)
	* @param  obj
	* @param  request    参数
	* @return void    返回类型
	* @throws
	 */
	public void insert(Voting obj,HttpServletRequest request){
		if (StringUtil.isNullOrEmpty(obj.getTitle())) {
			throw new RuntimeException("标题不能为空.");
		}
		if (StringUtil.isNullOrEmpty(obj.getImg())) {
			throw new RuntimeException("请上传活动封面图片！");
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


	/**
	 * 
	* @Title: update
	* @Description: TODO(修改投票活动)
	* @param  obj
	* @param  request
	* @param @return    参数
	* @return int    返回类型
	* @throws
	 */
	public int update(Voting obj,HttpServletRequest request){
		if (obj.getId()==null||obj.getId()<1) {
			throw new RuntimeException("非法访问.");
		}
		if (StringUtil.isNullOrEmpty(obj.getTitle())) {
			throw new RuntimeException("标题不能为空.");
		}
		if (StringUtil.isNullOrEmpty(obj.getImg())) {
			throw new RuntimeException("请上传活动封面图片！");
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
		if(obj.getStatus()==1) {//如果当前状态选择0，获取已存在的为1状态的记录id
			Long sid=(long) 0;
			sid=votingDAO.getstatusid();
			if(sid>0) {
				votingDAO.updatestatus(sid);//修改状态为0
			}
		}
		int i = votingDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("修改失败,请稍后重试.");
		}
		return votingDAO.update(obj);
	}


	/**
	 * 
	* @Title: delete
	* @Description: TODO(删除活动)
	* @param  id    参数
	* @return void    返回类型
	* @throws
	 */
	public void delete(Long id){
		if (id==null||id<1) {
			throw new RuntimeException("非法访问.");
		}
			int i = votingDAO.delete(id);
			if (i!=1) {
				throw new RuntimeException("删除失败,请稍后重试.");
			}
	}

	@Transactional
	public Voting selectOneById(Long id){
		return votingDAO.selectOneById(id);
	}

	@Transactional
	public List<Voting> selectAll(Map map){
		return votingDAO.selectAll(map);
	}
	@Transactional
	public List<Voting> selectvotinglist(){
		return votingDAO.selectvotinglist();
	}
	@Transactional
	public int upvist() {
		return votingDAO.upvist();
	}
	public String getvrule() {
		return votingDAO.getvrule();
	}
}