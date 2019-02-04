package com.pydyun.ims.model;

public class WxLabel {
	private Integer lid;// 标签ID
	// private Integer urid;// 创建人ID
	// private Integer lcid;// 标签分类ID
	private String lcinfo;// 内容
	// private String lcdate;// 标签创建时间

	public WxLabel(String lcinfo) {
		super();
		this.lcinfo = lcinfo;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	@Override
	public String toString() {
		return "WxLabel [lcinfo=" + lcinfo + "]";
	}

	public String getLcinfo() {
		return lcinfo;
	}

	public void setLcinfo(String lcinfo) {
		this.lcinfo = lcinfo;
	}

	public WxLabel() {
		super();
	}
}
