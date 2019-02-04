package com.pydyun.ims.model;

public class WxImages {

	private Integer iid;// 相片id
	 private Integer aid;// 所属相册id
	// private String iname;// 相片名
	private String iurl;// 资源地址
//	private String iimgurl;// 资源小图地址
	// private String idate;// 上传时间

	public WxImages(String iurl, String iimgurl) {
		super();
		this.iurl = iurl;
//		this.iimgurl = iimgurl;
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

	public WxImages(Integer aid) {
	super();
	this.aid = aid;
}

	public WxImages() {
		super();
	}

	public String getIurl() {
		return iurl;
	}

	public void setIurl(String iurl) {
		this.iurl = iurl;
	}

//	public String getIimgurl() {
//		return iimgurl;
//	}
//
//	public void setIimgurl(String iimgurl) {
//		this.iimgurl = iimgurl;
//	}

}
