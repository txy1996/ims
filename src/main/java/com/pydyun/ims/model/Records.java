package com.pydyun.ims.model;

import java.util.Date;

public class Records {
	private int id;
	private String vrange;
	private Date regdate;
	private int rnumber;
	private int vorc;
	private int uaid;
	private String info;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVrange() {
		return vrange;
	}
	public void setVrange(String vrange) {
		this.vrange = vrange;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getRnumber() {
		return rnumber;
	}
	public void setRnumber(int rnumber) {
		this.rnumber = rnumber;
	}
	public int getVorc() {
		return vorc;
	}
	public void setVorc(int vorc) {
		this.vorc = vorc;
	}
	public int getUaid() {
		return uaid;
	}
	public void setUaid(int uaid) {
		this.uaid = uaid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
