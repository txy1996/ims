package com.pydyun.ims.model;

import java.util.List;

public class WxCoupon {
	private String csdate;// 有效期起
	private String codate;// 有效期止
	private String cfullcut;// 满减，如满100减20
	private String csum;// 金额(50)
	private String cprice;// 优惠券销售价
	private String ctitle;// 优惠券名字
	private String cinfo;// 优惠券介绍
	private String cimg; //优惠券图片
    private List<WxVoucher> listv;

	public String getCimg() {
		return cimg;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCinfo() {
		return cinfo;
	}

	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}

	public void setCimg(String cimg) {
		this.cimg = cimg;
	}

	public List<WxVoucher> getListv() {
		return listv;
	}

	public void setListv(List<WxVoucher> listv) {
		this.listv = listv;
	}

	public WxCoupon() {
		super();
	}

	public String getCsdate() {
		return csdate;
	}

	public void setCsdate(String csdate) {
		this.csdate = csdate;
	}

	public String getCfullcut() {
		return cfullcut;
	}

	public void setCfullcut(String cfullcut) {
		this.cfullcut = cfullcut;
	}

	public String getCodate() {
		return codate;
	}

	public void setCodate(String codate) {
		this.codate = codate;
	}

	public String getCsum() {
		return csum;
	}

	public void setCsum(String csum) {
		this.csum = csum;
	}

	public String getCprice() {
		return cprice;
	}

	public void setCprice(String cprice) {
		this.cprice = cprice;
	}

}
