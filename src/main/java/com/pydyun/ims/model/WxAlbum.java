package com.pydyun.ims.model;

public class WxAlbum {
	private Integer aid;//列注释
	private Integer sid;//商户id，三选一
//	private Integer ssid;//方案阶段id，三选一
//	private Integer faid;//方案id，三选一
//	private String aname;//相册名
//	private String ainfo;//相册简介
	private String aimg;//封面小图地址
//	private Integer urid;//创建人id，因为方案是允许普通用户创建的，所以创建人也可能就是users表的id，与auid二选一
//	private Integer auid;//如果是商户或者本站后台工作人员操作，则用这个字段记录auid，与urid二选一
	// private String adate;//创建时间
    private WxImages wximages;
	public WxImages getWximages() {
		return wximages;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public void setWximages(WxImages wximages) {
		this.wximages = wximages;
	}

	public WxAlbum(WxImages wximages) {
	super();
	this.wximages = wximages;
}

	public WxAlbum(String aimg) {
		super();
		this.aimg = aimg;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAimg() {
		return aimg;
	}

	public void setAimg(String aimg) {
		this.aimg = aimg;
	}

	public WxAlbum() {
		super();
	}
}
