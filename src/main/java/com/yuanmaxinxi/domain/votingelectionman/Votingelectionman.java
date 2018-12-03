package com.yuanmaxinxi.domain.votingelectionman;
public class Votingelectionman{
	private Long id;
	private Long vId;
	private Long eId;
	private int number;
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id=id;
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
	public int getNumber(){
		return this.number;
	}
	public void setNumber(int number){
		this.number=number;
	}
}