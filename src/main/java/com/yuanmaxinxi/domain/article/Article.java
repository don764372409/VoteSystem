package com.yuanmaxinxi.domain.article;
import java.util.Date;
public class Article{
	private Long atpid;
	private String atcontent;
	private int atid;
	private Date addtime;
	private Long admin_id;
	public Long getAtpid(){
		return this.atpid;
	}
	public void setAtpid(Long atpid){
		this.atpid=atpid;
	}
	public String getAtcontent(){
		return this.atcontent;
	}
	public void setAtcontent(String atcontent){
		this.atcontent=atcontent;
	}
	public int getAtid(){
		return this.atid;
	}
	public void setAtid(int atid){
		this.atid=atid;
	}
	public Date getAddtime(){
		return this.addtime;
	}
	public void setAddtime(Date addtime){
		this.addtime=addtime;
	}
	public Long getAdmin_id(){
		return this.admin_id;
	}
	public void setAdmin_id(Long admin_id){
		this.admin_id=admin_id;
	}
}