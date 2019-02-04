package com.pydyun.ims.model;

public class Goods_user {
	private Integer gid;// 金币ID
	private Integer urid;// 拥有该金币用户ID，与商户二选一
	private Integer gnum;// 当前数量
	private Integer gonum;// 操作数量
	private String goinfo;// 操作原因
	private String godate;// 操作时间
//	private Users users;//用户信息
	private Sys_User sys_user;
	
public Sys_User getSys_user() {
		return sys_user;
	}
	public void setSys_user(Sys_User sys_user) {
		this.sys_user = sys_user;
	}
public Goods_user(Sys_User sys_user) {
	super();
	this.sys_user = sys_user;
}
//	public Users getUsers() {
//		return users;
//	}
//	public void setUsers(Users users) {
//		this.users = users;
//	}
//	public Goods_user(Users users) {
//		super();
//		this.users = users;
//	}
	public Goods_user(Integer gid, Integer urid, Integer gnum, Integer gonum,
			String goinfo, String godate) {
		super();
		this.gid = gid;
		this.urid = urid;
		this.gnum = gnum;
		this.gonum = gonum;
		this.goinfo = goinfo;
		this.godate = godate;
	}
	public Goods_user() {
		super();
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}
	public Integer getGnum() {
		return gnum;
	}
	public void setGnum(Integer gnum) {
		this.gnum = gnum;
	}
	public Integer getGonum() {
		return gonum;
	}
	public void setGonum(Integer gonum) {
		this.gonum = gonum;
	}
	public String getGoinfo() {
		return goinfo;
	}
	public void setGoinfo(String goinfo) {
		this.goinfo = goinfo;
	}
	public String getGodate() {
		return godate;
	}
	public void setGodate(String godate) {
		this.godate = godate;
	}
	
}
