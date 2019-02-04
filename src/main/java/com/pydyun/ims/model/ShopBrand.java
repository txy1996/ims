package com.pydyun.ims.model;



public class ShopBrand {
	private Integer bid;// 品牌ID
	private String bname;// 品牌名
	private String binfo;// 品牌介绍

	public ShopBrand() {
		super();
	}

	public ShopBrand(Integer bid, String bname, String binfo) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.binfo = binfo;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBinfo() {
		return binfo;
	}

	public void setBinfo(String binfo) {
		this.binfo = binfo;
	}
}
