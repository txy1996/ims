package com.pydyun.ims.model;

import java.util.Date;

public class Preference {
	private Integer pid;
	private Integer lid;
	private Integer urid;
	private String ptype;
	private Date prdate;
	private String pinfo;
	private Integer pnumber;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public Date getPrdate() {
		return prdate;
	}
	public void setPrdate(Date prdate) {
		this.prdate = prdate;
	}
	public String getPinfo() {
		return pinfo;
	}
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}
	public Integer getPnumber() {
		return pnumber;
	}
	public void setPnumber(Integer pnumber) {
		this.pnumber = pnumber;
	}
	
}
