package com.pydyun.ims.model;

public class WxVoucher {
	private String vmoney; //代金券面额
	private String vprice; //代金券销售价
	private String vsdate; //代金券生效日期
	private String vodate; //代金券失效日期
	private String vtitle; //代金券名字
	private String vinfo; //代金券简介
	private String vimg; //代金券图片
	public WxVoucher() {
		super();
	}
	
	public String getVtitle() {
		return vtitle;
	}

	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}

	public String getVinfo() {
		return vinfo;
	}

	public void setVinfo(String vinfo) {
		this.vinfo = vinfo;
	}

	public String getVsdate() {
		return vsdate;
	}

	public void setVsdate(String vsdate) {
		this.vsdate = vsdate;
	}

	public String getVimg() {
		return vimg;
	}
	public void setVimg(String vimg) {
		this.vimg = vimg;
	}
	public String getVmoney() {
		return vmoney;
	}
	public void setVmoney(String vmoney) {
		this.vmoney = vmoney;
	}
	public String getVprice() {
		return vprice;
	}
	public void setVprice(String vprice) {
		this.vprice = vprice;
	}
	public String getVodate() {
		return vodate;
	}
	public void setVodate(String vodate) {
		this.vodate = vodate;
	}
	
}
