package com.yuanmaxinxi.domain.candidate;
public class Candidate{
	private Long id;
	private String name;
	private String img;
	private Long organize;
	private String describe;
	private int state;
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
	public String getImg(){
		return this.img;
	}
	public void setImg(String img){
		this.img=img;
	}
	public Long getOrganize(){
		return this.organize;
	}
	public void setOrganize(Long organize){
		this.organize=organize;
	}
	public String getDescribe(){
		return this.describe;
	}
	public void setDescribe(String describe){
		this.describe=describe;
	}
	public int getState(){
		return this.state;
	}
	public void setState(int state){
		this.state=state;
	}
}