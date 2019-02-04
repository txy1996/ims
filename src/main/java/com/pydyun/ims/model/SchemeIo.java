package com.pydyun.ims.model;

//
public class SchemeIo {    
	private Integer sid;
	private Integer scid;
	private Integer urid;
	private String sname;
	private String sinfo;
	private Integer spraise;
	private Integer soppose;
	private Integer sstate;
	private String sdate;
	private Scheme_class scheme_class;
//	private ArrayList<Scheme_stage> sctage;
	private Scheme_stage sctage;
//	private User user;
	private Sys_User sys_user;//用户信息
	
	public SchemeIo() {
	super();
}
	public SchemeIo(Integer sid, Integer scid, Integer urid, String sname, String sinfo,
			Integer spraise, Integer soppose, Integer sstate, String sdate,
			Scheme_class scheme_class, Scheme_stage sctage, Sys_User sys_user) {
		super();
		this.sid = sid;
		this.scid = scid;
		this.urid = urid;
		this.sname = sname;
		this.sinfo = sinfo;
		this.spraise = spraise;
		this.soppose = soppose;
		this.sstate = sstate;
		this.sdate = sdate;
		this.scheme_class = scheme_class;
		this.sctage = sctage;
		this.sys_user = sys_user;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSinfo() {
		return sinfo;
	}
	public void setSinfo(String sinfo) {
		this.sinfo = sinfo;
	}
	public Integer getSpraise() {
		return spraise;
	}
	public void setSpraise(Integer spraise) {
		this.spraise = spraise;
	}
	public Integer getSoppose() {
		return soppose;
	}
	public void setSoppose(Integer soppose) {
		this.soppose = soppose;
	}
	public Integer getSstate() {
		return sstate;
	}
	public void setSstate(Integer sstate) {
		this.sstate = sstate;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Scheme_class getScheme_class() {
		return scheme_class;
	}
	public void setScheme_class(Scheme_class scheme_class) {
		this.scheme_class = scheme_class;
	}
	public Scheme_stage getSctage() {
		return sctage;
	}
	public void setSctage(Scheme_stage sctage) {
		this.sctage = sctage;
	}
	public Sys_User getSys_user() {
		return sys_user;
	}
	public void setSys_user(Sys_User sys_user) {
		this.sys_user = sys_user;
	}
	
	
	
}
