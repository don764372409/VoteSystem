package com.yuanmaxinxi.domain.role;
public class Role{
	private Long id;
	private String name;
	private int dataRange;//数据范围  0-当前部门  1-当前机构  2-当前机构及下级机构  3-所有机构
	
	public int getDataRange() {
		return dataRange;
	}
	public void setDataRange(int dataRange) {
		this.dataRange = dataRange;
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
}