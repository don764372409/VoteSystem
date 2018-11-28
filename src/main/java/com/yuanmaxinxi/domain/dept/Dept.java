package com.yuanmaxinxi.domain.dept;
public class Dept{
	private Long id;
	private String name;
	private Long pId;
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
}