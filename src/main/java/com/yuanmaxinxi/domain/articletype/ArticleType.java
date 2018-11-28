package com.yuanmaxinxi.domain.articletype;
public class ArticleType{
	private Long atid;
	private String atname;
	private Long pid;
	public Long getAtid(){
		return this.atid;
	}
	public void setAtid(Long atid){
		this.atid=atid;
	}
	public String getAtname(){
		return this.atname;
	}
	public void setAtname(String atname){
		this.atname=atname;
	}
	public Long getPid(){
		return this.pid;
	}
	public void setPid(Long pid){
		this.pid=pid;
	}
}