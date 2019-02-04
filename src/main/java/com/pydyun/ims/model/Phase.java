package com.pydyun.ims.model;

import java.util.List;

public class Phase {
	private int ssid;
	private int sid;
	private String ssname;
	private String ssinfo;
	private Plan plan; //关联方案信息
	private List<Listings> listings; //关联方案所含商家列表
	public int getSsid() {
		return ssid;
	}
	public void setSsid(int ssid) {
		this.ssid = ssid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSsname() {
		return ssname;
	}
	public void setSsname(String ssname) {
		this.ssname = ssname;
	}
	public String getSsinfo() {
		return ssinfo;
	}
	public void setSsinfo(String ssinfo) {
		this.ssinfo = ssinfo;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public List<Listings> getListings() {
		return listings;
	}
	public void setListings(List<Listings> listings) {
		this.listings = listings;
	}
	
}