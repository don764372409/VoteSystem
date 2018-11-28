package com.yuanmaxinxi.domain.role;
public class Role{
	private Long id;
	private String name;
	private Long deptId;
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
	public Long getDeptId(){
		return this.deptId;
	}
	public void setDeptId(Long deptId){
		this.deptId=deptId;
	}
}