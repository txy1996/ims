package com.pydyun.ims.model;

public class Zone {
	private int zid;
	private String zname;
	private int z_zid;
	public int getZid() {
		return zid;
	}
	public void setZid(int zid) {
		this.zid = zid;
	}
	public String getZname() {
		return zname;
	}
	public void setZname(String zname) {
		this.zname = zname;
	}
	public int getZ_zid() {
		return z_zid;
	}
	public void setZ_zid(int z_zid) {
		this.z_zid = z_zid;
	}
	@Override
	public String toString() {
		return "zone [zid=" + zid + ", zname=" + zname  +"]";
	}
	
	
}
