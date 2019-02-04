package com.pydyun.ims.model;

public class User_position {
	private Integer upid;
	private String upsort;
	private String upsdate;
	private String upodate;
	private Integer urid;
	private Integer cid;
	private Integer pid;
//	private User user;
	private Position position;
	private Company company;
	private Sys_User sys_user;
	public Sys_User getSys_user() {
		return sys_user;
	}
	public void setSys_user(Sys_User sys_user) {
		this.sys_user = sys_user;
	}
	
	public Integer getUpid() {
		return upid;
	}
	public void setUpid(Integer upid) {
		this.upid = upid;
	}
	public String getUpsort() {
		return upsort;
	}
	public void setUpsort(String upsort) {
		this.upsort = upsort;
	}
	
	public String getUpsdate() {
		return upsdate;
	}
	public void setUpsdate(String upsdate) {
		this.upsdate = upsdate;
	}
	public String getUpodate() {
		return upodate;
	}
	public void setUpodate(String upodate) {
		this.upodate = upodate;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
