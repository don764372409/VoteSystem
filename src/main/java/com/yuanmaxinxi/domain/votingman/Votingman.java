package com.yuanmaxinxi.domain.votingman;
import java.util.Date;
public class Votingman{
	private Long id;
	private String openid;
	private Long vId;
	private Long eId;
	private Date time;
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id=id;
	}
	public String getOpenid(){
		return this.openid;
	}
	public void setOpenid(String openid){
		this.openid=openid;
	}
	public Long getVId(){
		return this.vId;
	}
	public void setVId(Long vId){
		this.vId=vId;
	}
	public Long getEId(){
		return this.eId;
	}
	public void setEId(Long eId){
		this.eId=eId;
	}
	public Date getTime(){
		return this.time;
	}
	public void setTime(Date time){
		this.time=time;
	}
}