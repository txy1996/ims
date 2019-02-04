package com.pydyun.ims.model;

public class WxProductClass {
	private Integer id;
	private Integer cid;// 所属分类
	private String cname;//分类名
	private String ccname;//商品大分类
//	private WxProductClass wxproductclass;
	private WxProduct wxproduct;// 具体商品类
	private WxShop wxshop;// 商品类对应商户
	private WxProductimg wximg;//商品对应图片
	private Integer templet_list;
	private Integer templet_product;
	
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
//	public WxProductClass getWxproductclass() {
//		return wxproductclass;
//	}
//	public void setWxproductclass(WxProductClass wxproductclass) {
//		this.wxproductclass = wxproductclass;
//	}
	public Integer getTemplet_product() {
		return templet_product;
	}
	public void setTemplet_product(Integer templet_product) {
		this.templet_product = templet_product;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTemplet_list() {
		return templet_list;
	}
	public void setTemplet_list(Integer templet_list) {
		this.templet_list = templet_list;
	}
	public WxProductimg getWximg() {
		return wximg;
	}
	public void setWximg(WxProductimg wximg) {
		this.wximg = wximg;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public WxProduct getWxproduct() {
		return wxproduct;
	}
	public void setWxproduct(WxProduct wxproduct) {
		this.wxproduct = wxproduct;
	}
	public WxShop getWxshop() {
		return wxshop;
	}
	public void setWxshop(WxShop wxshop) {
		this.wxshop = wxshop;
	}

}
