package com.yuanmaxinxi.domain.article;
import java.util.Date;
public class Article{
	private Long id;
	private String title;
	private String content;
	private Date time;
	private Long aId;
	private String fail;
	private int state;
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
	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content=content;
	}
	public Date getTime(){
		return this.time;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public Long getAId(){
		return this.aId;
	}
	public void setAId(Long aId){
		this.aId=aId;
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