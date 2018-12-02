package com.yuanmaxinxi.domain.dept;

import com.yuanmaxinxi.domain.organize.Organize;

public class Dept{
	private Long id;
	private String name;
	private Long organizeId;
	private Organize organize;
	
	public Organize getOrganize() {
		return organize;
	}
	public void setOrganize(Organize organize) {
		this.organize = organize;
	}
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
	public Long getOrganizeId() {
		return organizeId;
	}
	public void setOrganizeId(Long organizeId) {
		this.organizeId = organizeId;
	}
}