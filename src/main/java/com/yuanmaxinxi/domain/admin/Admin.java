package com.yuanmaxinxi.domain.admin;
public class Admin{
	private Long id;
	private String name;
	private String username;
	private String password;
	private int status;
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
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
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