package com.yuanmaxinxi.domain.resource;
public class Resource{
	private Long id;
	private String name;
	private String pId;
	private String icon;
	private int type;
	private String url;
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
	public String getPId(){
		return this.pId;
	}
	public void setPId(String pId){
		this.pId=pId;
	}
	public String getIcon(){
		return this.icon;
	}
	public void setIcon(String icon){
		this.icon=icon;
	}
	public int getType(){
		return this.type;
	}
	public void setType(int type){
		this.type=type;
	}
	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url=url;
	}
}