package com.pydyun.ims.model;

public class ShopLevel {
	private Integer slid;//平台店铺的等级名称id
	private String slname;//平台店铺的等级名
	private Integer slintegration;//该等级的积分范围
	private String slinfo;//等级的说明
	public ShopLevel(Integer slid, String slname, Integer slintegration,
			String slinfo) {
		super();
		this.slid = slid;
		this.slname = slname;
		this.slintegration = slintegration;
		this.slinfo = slinfo;
	}
	public ShopLevel() {
		super();
	}
	public Integer getSlid() {
		return slid;
	}
	public void setSlid(Integer slid) {
		this.slid = slid;
	}
	public String getSlname() {
		return slname;
	}
	public void setSlname(String slname) {
		this.slname = slname;
	}
	public Integer getSlintegration() {
		return slintegration;
	}
	public void setSlintegration(Integer slintegration) {
		this.slintegration = slintegration;
	}
	public String getSlinfo() {
		return slinfo;
	}
	public void setSlinfo(String slinfo) {
		this.slinfo = slinfo;
	}
	
}
