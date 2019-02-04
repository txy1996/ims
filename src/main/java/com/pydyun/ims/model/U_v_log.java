package com.pydyun.ims.model;

import java.util.Date;

public class U_v_log {
	private Integer uvlid;
	private Integer vid;
	private Integer sid;
	private Integer tourid;
	private Integer urid;
	private Integer auid;
	private Date uvlgetdate;
	private String uvlgetchannel;
	private String uvltype;
	private Date uvlInvalid;
	private Integer uvlstate;
	private Integer uvlassess;
	private String uvinfo;
	private ShopBrand sb;
	private Shop s;
	private Voucher vou;
	private String a;
	private String uvcode;
	private String uvimg;
	
	public String getUvcode() {
		return uvcode;
	}
	public void setUvcode(String uvcode) {
		this.uvcode = uvcode;
	}
	public String getUvimg() {
		return uvimg;
	}
	public void setUvimg(String uvimg) {
		this.uvimg = uvimg;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public Integer getUvlid() {
		return uvlid;
	}
	public void setUvlid(Integer uvlid) {
		this.uvlid = uvlid;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getTourid() {
		return tourid;
	}
	public void setTourid(Integer tourid) {
		this.tourid = tourid;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}
	public Integer getAuid() {
		return auid;
	}
	public void setAuid(Integer auid) {
		this.auid = auid;
	}
	public Date getUvlgetdate() {
		return uvlgetdate;
	}
	public void setUvlgetdate(Date uvlgetdate) {
		this.uvlgetdate = uvlgetdate;
	}
	public String getUvlgetchannel() {
		return uvlgetchannel;
	}
	public void setUvlgetchannel(String uvlgetchannel) {
		this.uvlgetchannel = uvlgetchannel;
	}
	public String getUvltype() {
		return uvltype;
	}
	public void setUvltype(String uvltype) {
		this.uvltype = uvltype;
	}
	public Date getUvlInvalid() {
		return uvlInvalid;
	}
	public void setUvlInvalid(Date uvlInvalid) {
		this.uvlInvalid = uvlInvalid;
	}
	public Integer getUvlstate() {
		return uvlstate;
	}
	public void setUvlstate(Integer uvlstate) {
		this.uvlstate = uvlstate;
	}
	public Integer getUvlassess() {
		return uvlassess;
	}
	public void setUvlassess(Integer uvlassess) {
		this.uvlassess = uvlassess;
	}
	public String getUvinfo() {
		return uvinfo;
	}
	public void setUvinfo(String uvinfo) {
		this.uvinfo = uvinfo;
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
	public Voucher getVou() {
		return vou;
	}
	public void setVou(Voucher vou) {
		this.vou = vou;
	}
	
}
