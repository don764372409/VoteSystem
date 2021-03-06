package com.yuanmaxinxi.domain.article;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.yuanmaxinxi.domain.articletype.ArticleType;
import com.yuanmaxinxi.domain.dept.Dept;
public class Article{
	private Long id;
	private String img;
	private String title;
	private String content;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date time;
	private Long adId;
	private Long deptId;
	private Long aId;
	private String fail;
	private int state;//0-审核中  1-审核通过
	private Long typeId;
	private String timechange;
	private ArticleType articletype;
	private Dept dept;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Long getAdId() {
		return adId;
	}
	public void setAdId(Long adId) {
		this.adId = adId;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getTimechange() {
		return timechange;
	}
	public void setTimechange(String timechange) {
		this.timechange = timechange;
	}
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
	@Override
	public String toString() {
		return "Article [id=" + id + ", img=" + img + ", title=" + title + ", content=" + content + ", time=" + time
				+ ", aId=" + aId + ", fail=" + fail + ", state=" + state + ", typeId=" + typeId + ", articletype="
				+ articletype + "]";
	}
}