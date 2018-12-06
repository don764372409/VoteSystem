package com.yuanmaxinxi.domain.article;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.yuanmaxinxi.domain.articletype.ArticleType;
public class Article{
	private Long id;
	private String img;
	private String title;
	private String content;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date time;
	private Long aId;
	private String fail;
	private int state;
	private Long typeId;
	private ArticleType articletype;
	
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	public ArticleType getArticletype() {
		return articletype;
	}
	public void setArticletype(ArticleType articletype) {
		this.articletype = articletype;
	}
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id=id;
	}
	
	public String getImg(){
		return this.img;
	}
	public void setImg(String img){
		this.img=img;
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