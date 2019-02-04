package com.pydyun.ims.model;

public class Settings {
	private Integer id;
	private String systitle;
	private String sysstate;
	private String sysinfo;
	private String sysreadme;
	private String sysconnection;
	private String sysxcx; //二维码
	private String wxappid;	//微信秘钥
	private String wxappsecret;//微信校验码
	private String zfbappid; //支付宝秘钥
	private String zfbappsecret;	//支付宝校验码
	private String dxlogin;	//短信账号
	private String dxpwd;	//短信密码
	private String dxurl;	//短信地址
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSystitle() {
		return systitle;
	}
	public void setSystitle(String systitle) {
		this.systitle = systitle;
	}
	public String getSysstate() {
		return sysstate;
	}
	public void setSysstate(String sysstate) {
		this.sysstate = sysstate;
	}
	public String getSysinfo() {
		return sysinfo;
	}
	public void setSysinfo(String sysinfo) {
		this.sysinfo = sysinfo;
	}
	public String getSysreadme() {
		return sysreadme;
	}
	public void setSysreadme(String sysreadme) {
		this.sysreadme = sysreadme;
	}
	public String getSysconnection() {
		return sysconnection;
	}
	public void setSysconnection(String sysconnection) {
		this.sysconnection = sysconnection;
	}
	public String getSysxcx() {
		return sysxcx;
	}
	public void setSysxcx(String sysxcx) {
		this.sysxcx = sysxcx;
	}
	
	public String getWxappid() {
		return wxappid;
	}
	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}
	public String getWxappsecret() {
		return wxappsecret;
	}
	public void setWxappsecret(String wxappsecret) {
		this.wxappsecret = wxappsecret;
	}
	public String getZfbappid() {
		return zfbappid;
	}
	public void setZfbappid(String zfbappid) {
		this.zfbappid = zfbappid;
	}
	public String getZfbappsecret() {
		return zfbappsecret;
	}
	public void setZfbappsecret(String zfbappsecret) {
		this.zfbappsecret = zfbappsecret;
	}
	public String getDxlogin() {
		return dxlogin;
	}
	public void setDxlogin(String dxlogin) {
		this.dxlogin = dxlogin;
	}
	public String getDxpwd() {
		return dxpwd;
	}
	public void setDxpwd(String dxpwd) {
		this.dxpwd = dxpwd;
	}
	public String getDxurl() {
		return dxurl;
	}
	public void setDxurl(String dxurl) {
		this.dxurl = dxurl;
	}
}
