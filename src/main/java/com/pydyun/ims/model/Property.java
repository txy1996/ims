package com.pydyun.ims.model;

public class Property {
	private Integer id;
	private String name;
	private Integer pcid;
	private Integer pid;
	private String propertyvalue;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPcid() {
		return pcid;
	}
	public void setPcid(Integer pcid) {
		this.pcid = pcid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPropertyvalue() {
		return propertyvalue;
	}
	public void setPropertyvalue(String propertyvalue) {
		this.propertyvalue = propertyvalue;
	}
	
}
