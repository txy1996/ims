package com.pydyun.ims.model;

import java.util.Date;

public class U_c_log {
	private Integer uclid;
	private Integer urid;
	private Integer sid;
	private Integer auid;
	private Integer cid;
	private Date ucgetdate;
	private String ucgetchannel;
	private String ucgetinfo;
	private Date ucInvalid;	
	private Date ucodate;
	private Integer ucstate;
	private String ucinfo;
	private ShopBrand sb;
	private Shop s;
	private Coupon cou;
	private String a;
	private String uccode;
	private String ucimg;
	
	public String getUccode() {
		return uccode;
	}
	public void setUccode(String uccode) {
		this.uccode = uccode;
	}
	public String getUcimg() {
		return ucimg;
	}
	public void setUcimg(String ucimg) {
		this.ucimg = ucimg;
	}
	public Integer getUclid() {
		return uclid;
	}
	public void setUclid(Integer uclid) {
		this.uclid = uclid;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getAuid() {
		return auid;
	}
	public void setAuid(Integer auid) {
		this.auid = auid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Date getUcgetdate() {
		return ucgetdate;
	}
	public void setUcgetdate(Date ucgetdate) {
		this.ucgetdate = ucgetdate;
	}
	public String getUcgetchannel() {
		return ucgetchannel;
	}
	public void setUcgetchannel(String ucgetchannel) {
		this.ucgetchannel = ucgetchannel;
	}
	public String getUcgetinfo() {
		return ucgetinfo;
	}
	public void setUcgetinfo(String ucgetinfo) {
		this.ucgetinfo = ucgetinfo;
	}
	public Date getUcInvalid() {
		return ucInvalid;
	}
	public void setUcInvalid(Date ucInvalid) {
		this.ucInvalid = ucInvalid;
	}
	public Date getUcodate() {
		return ucodate;
	}
	public void setUcodate(Date ucodate) {
		this.ucodate = ucodate;
	}
	public Integer getUcstate() {
		return ucstate;
	}
	public void setUcstate(Integer ucstate) {
		this.ucstate = ucstate;
	}
	public String getUcinfo() {
		return ucinfo;
	}
	public void setUcinfo(String ucinfo) {
		this.ucinfo = ucinfo;
	}
	public ShopBrand getSb() {
		return sb;
	}
	public void setSb(ShopBrand sb) {
		this.sb = sb;
	}
	public Shop getS() {
		return s;
	}
	public void setS(Shop s) {
		this.s = s;
	}
	public Coupon getCou() {
		return cou;
	}
	public void setCou(Coupon cou) {
		this.cou = cou;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	
}
