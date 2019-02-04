package com.pydyun.ims.model;

import java.util.List;

public class Label_class { 

	private Integer lcid;// 标签分类ID
	private Integer lclcid;// 标签分类所属分类ID
	private String text;// 标签分类名
	private String lclcname;
	
	public String getLclcname() {
		return lclcname;
	}

	public void setLclcname(String lclcname) {
		this.lclcname = lclcname;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private List<Label> label;

	public Label_class(Integer lcid, Integer lclcid, String text) {
		super();
		this.lcid = lcid;
		this.lclcid = lclcid;
		this.text = text;
	}

	public List<Label> getLabel() {
		return label;
	}

	public void setLabel(List<Label> label) {
		this.label = label;
	}

	public Label_class(List<Label> label) {
		super();
		this.label = label;
	}

	public Label_class() {
		super();
	}

	public Integer getLcid() {
		return lcid;
	}

	public void setLcid(Integer lcid) {
		this.lcid = lcid;
	}

	public Integer getLclcid() {
		return lclcid;
	}

	public void setLclcid(Integer lclcid) {
		this.lclcid = lclcid;
	}

	@Override
	public String toString() {
		return "Label_class [lcid=" + lcid + ",  text="
				+ text + "  ]";
	}

}
