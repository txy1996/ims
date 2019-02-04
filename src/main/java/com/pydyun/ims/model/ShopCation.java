package com.pydyun.ims.model;

public class ShopCation {
	private Integer scid;// 商户分类ID
	private Integer scscid;// 所属分类
	private String scname;// 商户分类名
	private String scinfo;// 商户分类简介
	private Shop shop; //商户信息
	private String scscname;
	

	public String getScscname() {
		return scscname;
	}

	public void setScscname(String scscname) {
		this.scscname = scscname;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ShopCation(Shop shop) {
		super();
		this.shop = shop;
	}

	public ShopCation(Integer scid, Integer scscid, String scname,
			String scinfo) {
		super();
		this.scid = scid;
		this.scscid = scscid;
		this.scname = scname;
		this.scinfo = scinfo;
	}

	public ShopCation() {
		super();
	}

	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

	public Integer getScscid() {
		return scscid;
	}

	public void setScscid(Integer scscid) {
		this.scscid = scscid;
	}

	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public String getScinfo() {
		return scinfo;
	}

	public void setScinfo(String scinfo) {
		this.scinfo = scinfo;
	}

}
