package com.pydyun.ims.model;

public class Stage {
	private int ssid;
	private int sid;
	private String ssname;
	private String ssinfo;
	private Scheme scheme;
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
	public Scheme getScheme() {
		return scheme;
	}
	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}
	
}
