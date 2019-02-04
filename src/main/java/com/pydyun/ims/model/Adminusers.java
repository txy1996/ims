package com.pydyun.ims.model;

import java.util.Date;

public class Adminusers {
	private int auid;
	private int dtid;
	private String auname;
	private String aupwd;
	private Date aurdate;
	private Date auldate;
	private String aulip;
	public int getAuid() {
		return auid;
	}
	public void setAuid(int auid) {
		this.auid = auid;
	}
	public int getDtid() {
		return dtid;
	}
	public void setDtid(int dtid) {
		this.dtid = dtid;
	}
	public String getAuname() {
		return auname;
	}
	public void setAuname(String auname) {
		this.auname = auname;
	}
	public String getAupwd() {
		return aupwd;
	}
	public void setAupwd(String aupwd) {
		this.aupwd = aupwd;
	}
	public Date getAurdate() {
		return aurdate;
	}
	public void setAurdate(Date aurdate) {
		this.aurdate = aurdate;
	}
	public Date getAuldate() {
		return auldate;
	}
	public void setAuldate(Date auldate) {
		this.auldate = auldate;
	}
	public String getAulip() {
		return aulip;
	}
	public void setAulip(String aulip) {
		this.aulip = aulip;
	}	
	
	
}
