package com.pydyun.ims.model;

public class Slintegration {
	private Integer slid;// 获取积分的记录ID
	private Integer sid;// 商户ID
	private String sgetinfo;// 商户获得积分原因
	private Integer sgetnum;// 商户本次获得分值
	private String sgetdate;// 商户获得积分的时间
	private Integer ssum;// 商户当前积分总额
	private Shop shop; //商户信息

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Slintegration(Shop shop) {
		super();
		this.shop = shop;
	}

	public Slintegration(Integer slid, Integer sid, String sgetinfo,
			Integer sgetnum, String sgetdate, Integer ssum) {
		super();
		this.slid = slid;
		this.sid = sid;
		this.sgetinfo = sgetinfo;
		this.sgetnum = sgetnum;
		this.sgetdate = sgetdate;
		this.ssum = ssum;
	}

	public Slintegration() {
		super();
	}

	public Integer getSlid() {
		return slid;
	}

	public void setSlid(Integer slid) {
		this.slid = slid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSgetinfo() {
		return sgetinfo;
	}

	public void setSgetinfo(String sgetinfo) {
		this.sgetinfo = sgetinfo;
	}

	public Integer getSgetnum() {
		return sgetnum;
	}

	public void setSgetnum(Integer sgetnum) {
		this.sgetnum = sgetnum;
	}

	public String getSgetdate() {
		return sgetdate;
	}

	public void setSgetdate(String sgetdate) {
		this.sgetdate = sgetdate;
	}

	public Integer getSsum() {
		return ssum;
	}

	public void setSsum(Integer ssum) {
		this.ssum = ssum;
	}

}
