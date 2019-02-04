package com.pydyun.ims.model;

import java.util.List;

public class WxUser_assess {
	private Integer uaid;// 评价ID
	private Integer uaoid;// 被评价对象ID
	 private Integer uaotype;// 被评价对象的类型 0=商户，1=方案，2=阶段，3=商品
	private String ualabels;// 所选择标签列表（1,2,3,4
	private String uadate;// 评价时间
	private Integer uaisanonymous;// 是否匿名（默认匿名0=是，1=否）
	private Integer uanum;//评分
	private String uainfo;// 具体评价内容
    private WxSys_user wxsys_user;
    private WxImagesPl wximages_pl;
    private List<String> list;	
	
	public Integer getUanum() {
		return uanum;
	}
	public void setUanum(Integer uanum) {
		this.uanum = uanum;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}

	public Integer getUaotype() {
		return uaotype;
	}

	public void setUaotype(Integer uaotype) {
		this.uaotype = uaotype;
	}

	public String getUalabels() {
		return ualabels;
	}

	public void setUalabels(String ualabels) {
		this.ualabels = ualabels;
	}

	public Integer getUaid() {
		return uaid;
	}

	public void setUaid(Integer uaid) {
		this.uaid = uaid;
	}

	public Integer getUaoid() {
		return uaoid;
	}

	public void setUaoid(Integer uaoid) {
		this.uaoid = uaoid;
	}

	public Integer getUaisanonymous() {
		return uaisanonymous;
	}

	public void setUaisanonymous(Integer uaisanonymous) {
		this.uaisanonymous = uaisanonymous;
	}

	public WxImagesPl getWximages_pl() {
		return wximages_pl;
	}

	public void setWximages_pl(WxImagesPl wximages_pl) {
		this.wximages_pl = wximages_pl;
	}

	public WxSys_user getWxsys_user() {
		return wxsys_user;
	}

	public void setWxsys_user(WxSys_user wxsys_user) {
		this.wxsys_user = wxsys_user;
	}

	public WxUser_assess(WxSys_user wxsys_user) {
		super();
		this.wxsys_user = wxsys_user;
	}

	public WxUser_assess(String uadate, String uainfo) {
		super();
		this.uadate = uadate;
		this.uainfo = uainfo;
	}

	public WxUser_assess() {
		super();
	}

	public String getUadate() {
		return uadate;
	}

	public void setUadate(String uadate) {
		this.uadate = uadate;
	}

	public String getUainfo() {
		return uainfo;
	}

	public void setUainfo(String uainfo) {
		this.uainfo = uainfo;
	}

	@Override
	public String toString() {
		return "WxUser_assess [uaid=" + uaid + ", uaoid=" + uaoid + ", ualabels=" + ualabels + ", uadate=" + uadate
				+ ", uaisanonymous=" + uaisanonymous + ", uainfo=" + uainfo + ", wxsys_user=" + wxsys_user
				+ ", wximages_pl=" + wximages_pl + "]";
	}

}
