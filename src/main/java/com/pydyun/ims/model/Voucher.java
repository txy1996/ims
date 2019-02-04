package com.pydyun.ims.model;

import java.math.BigDecimal;

public class Voucher {
	private Integer vid;
	private Integer vcid; //代金券分类id
	private Integer vrid;
	private Voucherclass voucherclass; 
	private String vrange;
	private String vmoney;
	private String vcost;
	private String vprice;
	private String vsdate;
	private String vodate;
	private Integer visood;
	private Integer vgoods;
	private Integer vintegration;
	private String vimg;
	private String vtitle;
	private String vinfo;
	private String vrefund;
	private String uaid;
	private Integer vnum;
	private Integer vstore;
	private BigDecimal Xdprice;
	private String Xdpcid;
		
	public BigDecimal getXdprice() {
		return Xdprice;
	}
	public void setXdprice(BigDecimal xdprice) {
		Xdprice = xdprice;
	}
	public String getXdpcid() {
		return Xdpcid;
	}
	public void setXdpcid(String xdpcid) {
		Xdpcid = xdpcid;
	}
	public Integer getVnum() {
		return vnum;
	}
	public void setVnum(Integer vnum) {
		this.vnum = vnum;
	}
	public Integer getVstore() {
		return vstore;
	}
	public void setVstore(Integer vstore) {
		this.vstore = vstore;
	}
	private Adminusers adminusers;
	
	public Integer getVrid() {
		return vrid;
	}
	public void setVrid(Integer vrid) {
		this.vrid = vrid;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public Integer getVcid() {
		return vcid;
	}
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}
	public Voucherclass getVoucherclass() {
		return voucherclass;
	}
	public void setVoucherclass(Voucherclass voucherclass) {
		this.voucherclass = voucherclass;
	}
	public String getVrange() {
		return vrange;
	}
	public void setVrange(String vrange) {
		this.vrange = vrange;
	}
	public String getVmoney() {
		return vmoney;
	}
	public void setVmoney(String vmoney) {
		this.vmoney = vmoney;
	}
	public String getVcost() {
		return vcost;
	}
	public void setVcost(String vcost) {
		this.vcost = vcost;
	}
	public String getVprice() {
		return vprice;
	}
	public void setVprice(String vprice) {
		this.vprice = vprice;
	}
	public String getVsdate() {
		return vsdate;
	}
	public void setVsdate(String vsdate) {
		this.vsdate = vsdate;
	}
	public String getVodate() {
		return vodate;
	}
	public void setVodate(String vodate) {
		this.vodate = vodate;
	}
	public Integer getVisood() {
		return visood;
	}
	public void setVisood(Integer visood) {
		this.visood = visood;
	}
	public Integer getVgoods() {
		return vgoods;
	}
	public void setVgoods(Integer vgoods) {
		this.vgoods = vgoods;
	}
	public Integer getVintegration() {
		return vintegration;
	}
	public void setVintegration(Integer vintegration) {
		this.vintegration = vintegration;
	}
	public String getVimg() {
		return vimg;
	}
	public void setVimg(String vimg) {
		this.vimg = vimg;
	}
	public String getVtitle() {
		return vtitle;
	}
	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}
	public String getVinfo() {
		return vinfo;
	}
	public void setVinfo(String vinfo) {
		this.vinfo = vinfo;
	}
	public String getVrefund() {
		return vrefund;
	}
	public void setVrefund(String vrefund) {
		this.vrefund = vrefund;
	}
	public String getUaid() {
		return uaid;
	}
	public void setUaid(String uaid) {
		this.uaid = uaid;
	}
	public Adminusers getAdminusers() {
		return adminusers;
	}
	public void setAdminusers(Adminusers adminusers) {
		this.adminusers = adminusers;
	}

}
