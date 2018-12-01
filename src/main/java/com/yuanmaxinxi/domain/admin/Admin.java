package com.yuanmaxinxi.domain.admin;

import com.yuanmaxinxi.domain.dept.Dept;

public class Admin{
	private Long id;
	private String name;
	private String phone;
	private String password;
	private int status;
	private Long deptId;
	private Dept dept;
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
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
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus(){
		return this.status;
	}
	public void setStatus(int status){
		this.status=status;
	}
}