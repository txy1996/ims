package com.pydyun.ims.model;

import java.util.List;

public class StageIo {
	private int ssid;
	private int sid;
	private String ssname;
	private String ssinfo;
	private List<Scheme_shop> scheme_shop;
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
	public List<Scheme_shop> getScheme_shop() {
		return scheme_shop;
	}
	public void setScheme_shop(List<Scheme_shop> scheme_shop) {
		this.scheme_shop = scheme_shop;
	}
}
