package com.pydyun.ims.model;

public class Couponclass {

	private Integer ccid;// 优惠券分类ID
	private String ccname;// 优惠券分类名
	private String ccinfo;// 优惠券分类简介
	private Integer ccccid;// 所属上级分类
	public Couponclass(Integer ccid, String ccname, String ccinfo,
			Integer ccccid) {
		super();
		this.ccid = ccid;
		this.ccname = ccname;
		this.ccinfo = ccinfo;
		this.ccccid = ccccid;
	}
	public Couponclass() {
		super();
	}
	public Integer getCcid() {
		return ccid;
	}
	public void setCcid(Integer ccid) {
		this.ccid = ccid;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public String getCcinfo() {
		return ccinfo;
	}
	public void setCcinfo(String ccinfo) {
		this.ccinfo = ccinfo;
	}
	public Integer getCcccid() {
		return ccccid;
	}
	public void setCcccid(Integer ccccid) {
		this.ccccid = ccccid;
	}
	
}
