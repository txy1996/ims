package com.pydyun.ims.model;



public class Integrations {
	private Integer iid; // 获得积分的记录ID
	private Integer urid; // 用户ID
	private String igetdate; // 获得时间
	private String igetinfo; // 用户获得积分原因
	private Integer igetnum; // 用户本次获得分值
	private Integer isum; // 用户当前积分总额
//	private Users users;//用户信息
	private Sys_User sys_user; //用户信息
	
public Sys_User getSys_user() {
		return sys_user;
	}
	public void setSys_user(Sys_User sys_user) {
		this.sys_user = sys_user;
	}
public Integrations(Sys_User sys_user) {
	super();
	this.sys_user = sys_user;
}
//	public Users getUsers() {
//		return users;
//	}
//	public void setUsers(Users users) {
//		this.users = users;
//	}
//	public Integrations(Users users) {
//		super();
//		this.users = users;
//	}
	public Integrations(Integer iid, Integer urid, String igetdate,
			String igetinfo, Integer igetnum, Integer isum) {
		super();
		this.iid = iid;
		this.urid = urid;
		this.igetdate = igetdate;
		this.igetinfo = igetinfo;
		this.igetnum = igetnum;
		this.isum = isum;
	}
	public Integrations() {
		super();
	}
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}
	public String getIgetdate() {
		return igetdate;
	}
	public void setIgetdate(String igetdate) {
		this.igetdate = igetdate;
	}
	public String getIgetinfo() {
		return igetinfo;
	}
	public void setIgetinfo(String igetinfo) {
		this.igetinfo = igetinfo;
	}
	public Integer getIgetnum() {
		return igetnum;
	}
	public void setIgetnum(Integer igetnum) {
		this.igetnum = igetnum;
	}
	public Integer getIsum() {
		return isum;
	}
	public void setIsum(Integer isum) {
		this.isum = isum;
	}
	
}
