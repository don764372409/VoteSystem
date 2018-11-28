package com.yuanmaxinxi.domain.cvrelation;
public class Cvrelation{
	private Long id;
	private Long vid;
	private Long cid;
	private int count;
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id=id;
	}
	public Long getVid(){
		return this.vid;
	}
	public void setVid(Long vid){
		this.vid=vid;
	}
	public Long getCid(){
		return this.cid;
	}
	public void setCid(Long cid){
		this.cid=cid;
	}
	public int getCount(){
		return this.count;
	}
	public void setCount(int count){
		this.count=count;
	}
}