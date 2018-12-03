package com.yuanmaxinxi.domain.electionman;
public class Electionman{
	private Long id;
	private String name;
	private String img;
	private int number;
	private String remark;
	private Long deptId;
	private String fail;
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
	public int getNumber(){
		return this.number;
	}
	public void setNumber(int number){
		this.number=number;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public Long getDeptId(){
		return this.deptId;
	}
	public void setDeptId(Long deptId){
		this.deptId=deptId;
	}
	public String getFail(){
		return this.fail;
	}
	public void setFail(String fail){
		this.fail=fail;
	}
	public int getState(){
		return this.state;
	}
	public void setState(int state){
		this.state=state;
	}
}