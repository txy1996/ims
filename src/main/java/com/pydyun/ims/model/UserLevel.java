package com.pydyun.ims.model;

public class UserLevel {
	
	private int ulid;
	private String ulname;//等级名
	private int ulintegration;//本级的积分
	private String ulinfo; //等级说明
	
	public UserLevel() {
		super();
	}
	
	public int getUlid() {
		return ulid;
	}
	public void setUlid(int ulid) {
		this.ulid = ulid;
	}
	public String getUlname() {
		return ulname;
	}
	public void setUlname(String ulname) {
		this.ulname = ulname;
	}
	public int getUlintegration() {
		return ulintegration;
	}
	public void setUlintegration(int ulintegration) {
		this.ulintegration = ulintegration;
	}
	public String getUlinfo() {
		return ulinfo;
	}
	public void setUlinfo(String ulinfo) {
		this.ulinfo = ulinfo;
	}
	
}
