package com.yuanmaxinxi.domain.articletype;


public class ArticleType{
	private Long id;
	private String name;
	private Long pId;
	private String remark;
	private Long ArticleTypeId;
	private ArticleType ArticleType;
	public Long getArticleTypeId() {
		return ArticleTypeId;
	}
	public void setArticleTypeId(Long articleTypeId) {
		ArticleTypeId = articleTypeId;
	}
	public ArticleType getArticleType() {
		return ArticleType;
	}
	public void setArticleType(ArticleType articleType) {
		ArticleType = articleType;
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
	public Long getPId(){
		return this.pId;
	}
	public void setPId(Long pId){
		this.pId=pId;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
}