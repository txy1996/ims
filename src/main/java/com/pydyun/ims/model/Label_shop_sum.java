package com.pydyun.ims.model;

public class Label_shop_sum {
	private Integer lssid;
	private Integer sid;// 商户Id
	private WxLabel wxlabel;

	public WxLabel getWxlabel() {
		return wxlabel;
	}

	public void setWxlabel(WxLabel wxlabel) {
		this.wxlabel = wxlabel;
	}

	public Integer getLssid() {
		return lssid;
	}

	public void setLssid(Integer lssid) {
		this.lssid = lssid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getLsnum() {
		return lsnum;
	}

	public void setLsnum(Integer lsnum) {
		this.lsnum = lsnum;
	}

	public Label_shop_sum() {
		super();
	}

	public Label_shop_sum(Integer lssid, Integer sid, Integer lid, Integer lsnum) {
		super();
		this.lssid = lssid;
		this.sid = sid;
		this.lid = lid;
		this.lsnum = lsnum;
	}

	private Integer lid;// 标签ID
	private Integer lsnum; //    被选择次数
}
