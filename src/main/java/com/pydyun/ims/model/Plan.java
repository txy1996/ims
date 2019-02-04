package com.pydyun.ims.model;

import java.util.List;

public class Plan {
	private int sid;
	private int scid;
	private int urid;
	private String sname;
	private String sinfo;
	private int spraise;
	private int soppose;
	private int sstate;
	private String sdate;
	private Classify classify; //分类
	private List<Phase> phash; //方案对应的阶段
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
	public List<Phase> getPhash() {
		return phash;
	}
	public void setPhash(List<Phase> phash) {
		this.phash = phash;
	}
	public Classify getClassify() {
		return classify;
	}
	public void setClassify(Classify classify) {
		this.classify = classify;
	}
	
}
