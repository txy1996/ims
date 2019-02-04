package com.pydyun.ims.model;

import java.util.List;

public class Scheme_stageIo {
	private int ssid;
	private int sid;
	private String ssname;
	private String ssinfo;
	private List<Scheme> scheme;
	private List<Scheme_shop> scheme_shop;
	private List<Shop> shop;
	public int getSsid() {
		return ssid;
	}
	public void setSsid(int ssid) {
		this.ssid = ssid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSsname() {
		return ssname;
	}
	public void setSsname(String ssname) {
		this.ssname = ssname;
	}
	public String getSsinfo() {
		return ssinfo;
	}
	public void setSsinfo(String ssinfo) {
		this.ssinfo = ssinfo;
	}
	public List<Scheme> getScheme() {
		return scheme;
	}
	public void setScheme(List<Scheme> scheme) {
		this.scheme = scheme;
	}
	public List<Scheme_shop> getScheme_shop() {
		return scheme_shop;
	}
	public void setScheme_shop(List<Scheme_shop> scheme_shop) {
		this.scheme_shop = scheme_shop;
	}
	public List<Shop> getShop() {
		return shop;
	}
	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
}
