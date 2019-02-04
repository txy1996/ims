package com.pydyun.ims.model;

public class WxProductShop {
	private Integer sid;// 商户ID
	private String sname;// 商户名
	private String slogo;// 商户logo
	private String sinfo;// 商户logo
	private String stel;// 联系方式
	private String saddress;// 地址

	public String getStel() {
		return stel;
	}

	public void setStel(String stel) {
		this.stel = stel;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSinfo() {
		return sinfo;
	}

	public void setSinfo(String sinfo) {
		this.sinfo = sinfo;
	}

	public String getSlogo() {
		return slogo;
	}

	public void setSlogo(String slogo) {
		this.slogo = slogo;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
}
