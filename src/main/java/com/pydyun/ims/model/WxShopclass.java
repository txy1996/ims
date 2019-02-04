package com.pydyun.ims.model;

public class WxShopclass {
	
     private Integer scid; //商户分类ID
	 private WxShop wxshop;//对应商户
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public WxShop getWxshop() {
		return wxshop;
	}
	public void setWxshop(WxShop wxshop) {
		this.wxshop = wxshop;
	}
	 
}
