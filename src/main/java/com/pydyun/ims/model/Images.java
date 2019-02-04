package com.pydyun.ims.model;


public class Images {
	private Integer iid;//相片id
	private Integer aid;//所属相册id
	private String iname;//相片名
	private String iurl;//资源地址
	private String iimgurl;//资源小图地址
	private String idate;//上传时间
	private Shop shop;
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Images(Integer iid, Integer aid, String iname, String iurl,
			String iimgurl, String idate) {
		super();
		this.iid = iid;
		this.aid = aid;
		this.iname = iname;
		this.iurl = iurl;
		this.iimgurl = iimgurl;
		this.idate = idate;
	}
	public Images() {
		super();
	}
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIurl() {
		return iurl;
	}
	public void setIurl(String iurl) {
		this.iurl = iurl;
	}
	public String getIimgurl() {
		return iimgurl;
	}
	public void setIimgurl(String iimgurl) {
		this.iimgurl = iimgurl;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	@Override
	public String toString() {
		return "Images [iid=" + iid + ", aid=" + aid + ", iname=" + iname
				+ ", iurl=" + iurl + ", iimgurl=" + iimgurl + ", idate="
				+ idate + "]";
	}
	
}
