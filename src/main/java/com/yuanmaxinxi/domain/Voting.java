package com.yuanmaxinxi.domain;
import java.util.Date;
public class Voting{
	private Long id;
	private String title;
	private String rule;
	private int state;
	private Date starttime;
	private Date endtime;
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id=id;
	}
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getRule(){
		return this.rule;
	}
	public void setRule(String rule){
		this.rule=rule;
	}
	public int getState(){
		return this.state;
	}
	public void setState(int state){
		this.state=state;
	}
	public Date getStarttime(){
		return this.starttime;
	}
	public void setStarttime(Date starttime){
		this.starttime=starttime;
	}
	public Date getEndtime(){
		return this.endtime;
	}
	public void setEndtime(Date endtime){
		this.endtime=endtime;
	}
}