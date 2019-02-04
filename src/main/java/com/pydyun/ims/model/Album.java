package com.pydyun.ims.model;


public class Album {
	private Integer aid;//列注释
	private Integer sid;//商户id，三选一
	private Integer ssid;//方案阶段id，三选一
	private Integer faid;//方案id，三选一
	private String aname;//相册名
	private String ainfo;//相册简介
	private String aimg;//封面小图地址
	private Integer urid;//创建人id，因为方案是允许普通用户创建的，所以创建人也可能就是users表的id，与auid二选一
	private Integer auid;//如果是商户或者本站后台工作人员操作，则用这个字段记录auid，与urid二选一
	private String adate;//创建时间
	public Album(Integer aid, Integer sid, Integer ssid, Integer faid,
			String aname, String ainfo, String aimg, Integer urid,
			Integer auid, String adate) {
		super();
		this.aid = aid;
		this.sid = sid;
		this.ssid = ssid;
		this.faid = faid;
		this.aname = aname;
		this.ainfo = ainfo;
		this.aimg = aimg;
		this.urid = urid;
		this.auid = auid;
		this.adate = adate;
	}
	public Album() {
		super();
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getSsid() {
		return ssid;
	}
	public void setSsid(Integer ssid) {
		this.ssid = ssid;
	}
	public Integer getFaid() {
		return faid;
	}
	public void setFaid(Integer faid) {
		this.faid = faid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAinfo() {
		return ainfo;
	}
	public void setAinfo(String ainfo) {
		this.ainfo = ainfo;
	}
	public String getAimg() {
		return aimg;
	}
	public void setAimg(String aimg) {
		this.aimg = aimg;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}
	public Integer getAuid() {
		return auid;
	}
	public void setAuid(Integer auid) {
		this.auid = auid;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	@Override
	public String toString() {
		return "Album [aid=" + aid + ", sid=" + sid + ", ssid=" + ssid
				+ ", faid=" + faid + ", aname=" + aname + ", ainfo=" + ainfo
				+ ", aimg=" + aimg + ", urid=" + urid + ", auid=" + auid
				+ ", adate=" + adate + "]";
	}
	
}
