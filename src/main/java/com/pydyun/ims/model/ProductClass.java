package com.pydyun.ims.model;

public class ProductClass {
	private Integer id;
	private String text;
	private Integer cid;
	private Integer templet_list;
	private Integer templet_product;
	private String ccname;
	
	public Integer getTemplet_list() {
		return templet_list;
	}
	public void setTemplet_list(Integer templet_list) {
		this.templet_list = templet_list;
	}
	public Integer getTemplet_product() {
		return templet_product;
	}
	public void setTemplet_product(Integer templet_product) {
		this.templet_product = templet_product;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	
	
}
