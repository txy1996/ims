package com.pydyun.ims.model;

import java.sql.Date;
import java.util.List;

public class Users {
	private Integer urid;// 用户id
	private Integer zid;// 所属地区id
	private Integer utid;// 用户所属类型
	private String urname;// 登录名
	private String urpwd;// 密码
	private String urfname;// 网名
	private String urtname;// 真实姓名
	private String urtel;// 手机号码
	private Integer ursex;// 性别
	private Date urbirthday;// 年龄
	private String urface;// 头像
	private String urautograph;// 个人签名
	private String referee;// 推荐人id（u：1 或 s：1 ）用户推荐或者商户推荐
	private String wx_openid;// 用户的微信openid
	private String qq_openid;// 用户通过qq绑定的openid
	private String zfb_openid;// 用户通过支付宝的openid
	private List<Goods_user> goods_user; //用户

	public List<Goods_user> getGoods_user() {
		return goods_user;
	}

	public void setGoods_user(List<Goods_user> goods_user) {
		this.goods_user = goods_user;
	}

	public Users(List<Goods_user> goods_user) {
		super();
		this.goods_user = goods_user;
	}

	public Users() {
		super();
	}

	public Users(Integer urid, Integer zid, Integer utid, String urname,
			String urpwd, String urfname, String urtname, String urtel,
			Integer ursex, Date urbirthday, String urface, String urautograph,
			String referee, String wx_openid, String qq_openid,
			String zfb_openid) {
		super();
		this.urid = urid;
		this.zid = zid;
		this.utid = utid;
		this.urname = urname;
		this.urpwd = urpwd;
		this.urfname = urfname;
		this.urtname = urtname;
		this.urtel = urtel;
		this.ursex = ursex;
		this.urbirthday = urbirthday;
		this.urface = urface;
		this.urautograph = urautograph;
		this.referee = referee;
		this.wx_openid = wx_openid;
		this.qq_openid = qq_openid;
		this.zfb_openid = zfb_openid;
	}

	public Integer getUrid() {
		return urid;
	}

	public void setUrid(Integer urid) {
		this.urid = urid;
	}

	public Integer getZid() {
		return zid;
	}

	public void setZid(Integer zid) {
		this.zid = zid;
	}

	public Integer getUtid() {
		return utid;
	}

	public void setUtid(Integer utid) {
		this.utid = utid;
	}

	public String getUrname() {
		return urname;
	}

	public void setUrname(String urname) {
		this.urname = urname;
	}

	public String getUrpwd() {
		return urpwd;
	}

	public void setUrpwd(String urpwd) {
		this.urpwd = urpwd;
	}

	public String getUrfname() {
		return urfname;
	}

	public void setUrfname(String urfname) {
		this.urfname = urfname;
	}

	public String getUrtname() {
		return urtname;
	}

	public void setUrtname(String urtname) {
		this.urtname = urtname;
	}

	public String getUrtel() {
		return urtel;
	}

	public void setUrtel(String urtel) {
		this.urtel = urtel;
	}

	public Integer getUrsex() {
		return ursex;
	}

	public void setUrsex(Integer ursex) {
		this.ursex = ursex;
	}

	public Date getUrbirthday() {
		return urbirthday;
	}

	public void setUrbirthday(Date urbirthday) {
		this.urbirthday = urbirthday;
	}

	public String getUrface() {
		return urface;
	}

	public void setUrface(String urface) {
		this.urface = urface;
	}

	public String getUrautograph() {
		return urautograph;
	}

	public void setUrautograph(String urautograph) {
		this.urautograph = urautograph;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public String getWx_openid() {
		return wx_openid;
	}

	public void setWx_openid(String wx_openid) {
		this.wx_openid = wx_openid;
	}

	public String getQq_openid() {
		return qq_openid;
	}

	public void setQq_openid(String qq_openid) {
		this.qq_openid = qq_openid;
	}

	public String getZfb_openid() {
		return zfb_openid;
	}

	public void setZfb_openid(String zfb_openid) {
		this.zfb_openid = zfb_openid;
	}

}
