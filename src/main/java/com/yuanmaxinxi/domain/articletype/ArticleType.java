package com.yuanmaxinxi.domain.articletype;
public class ArticleType{
	private Long id;
	private String name;
	private Long pId;
	private String remark;
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id=id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public Long getPId(){
		return this.pId;
	}
	public void setPId(Long pId){
		this.pId=pId;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
}