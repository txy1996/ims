package com.pydyun.ims.model;

import java.util.List;

public class Scheme_scheme {
	private int sid;
	private int scid;
	private int urid;
	private String sname;
	private String sinfo;
	private int spraise;
	private int soppose;
	private int sstate;
	private String sdate;
	List<Scheme_class> scheme;
	List<Scheme_stage> scheme_stage;
	List<Scheme_shop> scheme_shop;
	List<Shop> shop;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public int getUrid() {
		return urid;
	}
	public void setUrid(int urid) {
		this.urid = urid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSinfo() {
		return sinfo;
	}
	public void setSinfo(String sinfo) {
		this.sinfo = sinfo;
	}
	public int getSpraise() {
		return spraise;
	}
	public void setSpraise(int spraise) {
		this.spraise = spraise;
	}
	public int getSoppose() {
		return soppose;
	}
	public void setSoppose(int soppose) {
		this.soppose = soppose;
	}
	public int getSstate() {
		return sstate;
	}
	public void setSstate(int sstate) {
		this.sstate = sstate;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public List<Scheme_class> getScheme() {
		return scheme;
	}
	public void setScheme(List<Scheme_class> scheme) {
		this.scheme = scheme;
	}
	public List<Scheme_stage> getScheme_stage() {
		return scheme_stage;
	}
	public void setScheme_stage(List<Scheme_stage> scheme_stage) {
		this.scheme_stage = scheme_stage;
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
