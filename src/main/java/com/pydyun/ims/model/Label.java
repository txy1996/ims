package com.pydyun.ims.model;


public class Label {

	private Integer lid;// 标签ID
	private Integer urid;// 创建人ID
	private Integer lcid;// 标签分类ID
	private String lcinfo;// 内容
	private String lcdate;// 标签创建时间
	private Integer fanum;//方案应用数
	private Integer jdnum;//阶段应用数
	private Integer shnum;//商户应用数
	private Integer yhnum;//用户应用数
	private String cjren;//创建人
	
	public Integer getFanum() {
		return fanum;
	}

	public void setFanum(Integer fanum) {
		this.fanum = fanum;
	}

	public Integer getJdnum() {
		return jdnum;
	}

	public void setJdnum(Integer jdnum) {
		this.jdnum = jdnum;
	}

	public Integer getShnum() {
		return shnum;
	}

	public void setShnum(Integer shnum) {
		this.shnum = shnum;
	}

	public Integer getYhnum() {
		return yhnum;
	}

	public void setYhnum(Integer yhnum) {
		this.yhnum = yhnum;
	}

	public String getCjren() {
		return cjren;
	}

	public void setCjren(String cjren) {
		this.cjren = cjren;
	}

	private Label_class labelclass;//标签分类

	public Label_class getLabelclass() {
		return labelclass;
	}

	public void setLabelclass(Label_class labelclass) {
		this.labelclass = labelclass;
	}

	public Label(Label_class labelclass) {
		super();
		this.labelclass = labelclass;
	}

	public Label(Integer lid, Integer urid, Integer lcid, String lcinfo,
			String lcdate) {
		super();
		this.lid = lid;
		this.urid = urid;
		this.lcid = lcid;
		this.lcinfo = lcinfo;
		this.lcdate = lcdate;
	}

	public Label() {
		super();
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getUrid() {
		return urid;
	}

	public void setUrid(Integer urid) {
		this.urid = urid;
	}

	public Integer getLcid() {
		return lcid;
	}

	public void setLcid(Integer lcid) {
		this.lcid = lcid;
	}

	public String getLcinfo() {
		return lcinfo;
	}

	public void setLcinfo(String lcinfo) {
		this.lcinfo = lcinfo;
	}

	public String getLcdate() {
		return lcdate;
	}

	public void setLcdate(String lcdate) {
		this.lcdate = lcdate;
	}

}
