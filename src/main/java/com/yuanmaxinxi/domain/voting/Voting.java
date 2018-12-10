package com.yuanmaxinxi.domain.voting;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Voting{
	private Long id;
	private String title;
	private String rule;
	private int status;
	private Long vist;
	private String img;
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date starttime;
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
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
	public int getStatus(){
		return this.status;
	}
	public void setStatus(int status){
		this.status=status;
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
	public Long getVist() {
		return vist;
	}
	public void setVist(Long vist) {
		this.vist = vist;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}