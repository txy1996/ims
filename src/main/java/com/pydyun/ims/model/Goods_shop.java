package com.pydyun.ims.model;


public class Goods_shop {
private Integer gid;//金币ID
private Integer sid;//拥有该金币商户ID，与用户二选一
private Integer gnum;//当前数量
private Integer gonum;//操作数量
private String goinfo;//操作原因
private String godate;//操作时间
private Shop shop; //商户信息
public Shop getShop() {
	return shop;
}
public void setShop(Shop shop) {
	this.shop = shop;
}
public Goods_shop(Shop shop) {
	super();
	this.shop = shop;
}
public Goods_shop() {
	super();
}
public Goods_shop(Integer gid, Integer sid, Integer gnum, Integer gonum,
		String goinfo, String godate) {
	super();
	this.gid = gid;
	this.sid = sid;
	this.gnum = gnum;
	this.gonum = gonum;
	this.goinfo = goinfo;
	this.godate = godate;
}
public Integer getGid() {
	return gid;
}
public void setGid(Integer gid) {
	this.gid = gid;
}
public Integer getSid() {
	return sid;
}
public void setSid(Integer sid) {
	this.sid = sid;
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
