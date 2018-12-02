package com.yuanmaxinxi.domain.organize;

import java.util.ArrayList;
import java.util.List;

import com.yuanmaxinxi.domain.dept.Dept;

public class Organize {
	private Long id;
	private String name;
	private Long pId;
	private Organize parent;
	private List<Organize> children = new ArrayList<>();
	private List<Dept> depts = new ArrayList<>();
	
	public List<Organize> getChildren() {
		return children;
	}
	public void setChildren(List<Organize> children) {
		this.children = children;
	}
	public List<Dept> getDepts() {
		return depts;
	}
	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public Organize getParent() {
		return parent;
	}
	public void setParent(Organize parent) {
		this.parent = parent;
	}
}
