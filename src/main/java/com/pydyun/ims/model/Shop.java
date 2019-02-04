package com.pydyun.ims.model;

import java.util.Date;
import java.util.List;

public class Shop {	
	private Integer sid;//商户id
	private Integer zid;//所在地区
	private Integer bid;//品牌id
	private Integer scid;//商户分类id
	private String sname;//商户名
	private String saddress;//地址
	private String stel;//订餐联系方式（文本框50字）
	private String scoordinate;//经纬度（1,1）
	private String scommerce;//商务洽谈联系方式
	private Integer sstate;//营业状态（0开业，1暂停营业，2闭店）
	private String sad;//编辑推荐（广告词）
	private String sinfo;//商户简介（需要富文本）
	private String ssort;//商户显示排序(分类:序号|分类:序号)
	private Integer sbalancetype;//商户协议结算模式（1银行转账、2支付宝、3微信、4线下结算）
	private String sbwx;//微信收款账号
	private String sbzfb;//支付宝收款账号
	private String sbyhk;//银行卡收款账号
	private String slogo;
	private String styleimg;
	private Date stime;
	private Date sutime;
	private String number;
	private String number1;
	private Records re;
	
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Date getSutime() {
		return sutime;
	}
	public void setSutime(Date sutime) {
		this.sutime = sutime;
	}
	public String getNumber1() {
		return number1;
	}
	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	public Records getRe() {
		return re;
	}
	public void setRe(Records re) {
		this.re = re;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	private List<Goods_shop> goods_shop;
	private Zone zone;
	private ShopCation sc;
	private ShopBrand sb;
	
	
	public Shop(Integer sid, Integer zid, Integer bid, Integer scid, String sname, String saddress, String stel,
			String scoordinate, String scommerce, Integer sstate, String sad, String sinfo, String ssort,
			Integer sbalancetype, String sbwx, String sbzfb, String sbyhk, String slogo, String styleimg, Records re,
			List<Goods_shop> goods_shop, Zone zone, ShopCation sc, ShopBrand sb) {
		super();
		this.sid = sid;
		this.zid = zid;
		this.bid = bid;
		this.scid = scid;
		this.sname = sname;
		this.saddress = saddress;
		this.stel = stel;
		this.scoordinate = scoordinate;
		this.scommerce = scommerce;
		this.sstate = sstate;
		this.sad = sad;
		this.sinfo = sinfo;
		this.ssort = ssort;
		this.sbalancetype = sbalancetype;
		this.sbwx = sbwx;
		this.sbzfb = sbzfb;
		this.sbyhk = sbyhk;
		this.slogo = slogo;
		this.styleimg = styleimg;
		this.re = re;
		this.goods_shop = goods_shop;
		this.zone = zone;
		this.sc = sc;
		this.sb = sb;
	}
	public ShopCation getSc() {
		return sc;
	}
	public void setSc(ShopCation sc) {
		this.sc = sc;
	}
	public ShopBrand getSb() {
		return sb;
	}
	public void setSb(ShopBrand sb) {
		this.sb = sb;
	}
	public List<Goods_shop> getGoods_shop() {
		return goods_shop;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public void setGoods_shop(List<Goods_shop> goods_shop) {
		this.goods_shop = goods_shop;
	}
	public Shop(List<Goods_shop> goods_shop) {
		super();
		this.goods_shop = goods_shop;
	}
	
	public Shop(Zone zone) {
		super();
		this.zone = zone;
	}
	public Shop() {
		super();
	}
	
	public Shop(Integer sid, Integer zid, Integer bid, Integer scid, String sname, String saddress, String stel,
			String scoordinate, String scommerce, Integer sstate, String sad, String sinfo, String ssort,
			Integer sbalancetype, String sbwx, String sbzfb, String sbyhk, String slogo, String styleimg) {
		super();
		this.sid = sid;
		this.zid = zid;
		this.bid = bid;
		this.scid = scid;
		this.sname = sname;
		this.saddress = saddress;
		this.stel = stel;
		this.scoordinate = scoordinate;
		this.scommerce = scommerce;
		this.sstate = sstate;
		this.sad = sad;
		this.sinfo = sinfo;
		this.ssort = ssort;
		this.sbalancetype = sbalancetype;
		this.sbwx = sbwx;
		this.sbzfb = sbzfb;
		this.sbyhk = sbyhk;
		this.slogo = slogo;
		this.styleimg = styleimg;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getZid() {
		return zid;
	}
	public void setZid(Integer zid) {
		this.zid = zid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public String getScoordinate() {
		return scoordinate;
	}
	public void setScoordinate(String scoordinate) {
		this.scoordinate = scoordinate;
	}
	public String getScommerce() {
		return scommerce;
	}
	public void setScommerce(String scommerce) {
		this.scommerce = scommerce;
	}
	public Integer getSstate() {
		return sstate;
	}
	public void setSstate(Integer sstate) {
		this.sstate = sstate;
	}
	public String getSad() {
		return sad;
	}
	public void setSad(String sad) {
		this.sad = sad;
	}
	public String getSinfo() {
		return sinfo;
	}
	public void setSinfo(String sinfo) {
		this.sinfo = sinfo;
	}
	public String getSsort() {
		return ssort;
	}
	public void setSsort(String ssort) {
		this.ssort = ssort;
	}
	public Integer getSbalancetype() {
		return sbalancetype;
	}
	public void setSbalancetype(Integer sbalancetype) {
		this.sbalancetype = sbalancetype;
	}
	public String getSbwx() {
		return sbwx;
	}
	public void setSbwx(String sbwx) {
		this.sbwx = sbwx;
	}
	public String getSbzfb() {
		return sbzfb;
	}
	public void setSbzfb(String sbzfb) {
		this.sbzfb = sbzfb;
	}
	public String getSbyhk() {
		return sbyhk;
	}
	public void setSbyhk(String sbyhk) {
		this.sbyhk = sbyhk;
	}
	public String getSlogo() {
		return slogo;
	}
	public void setSlogo(String slogo) {
		this.slogo = slogo;
	}
	public String getStyleimg() {
		return styleimg;
	}
	public void setStyleimg(String styleimg) {
		this.styleimg = styleimg;
	}
	
	@Override
	public String toString() {
		return "Shop [sid=" + sid + ", zid=" + zid + ", bid=" + bid + ", scid=" + scid + ", sname=" + sname
				+ ", saddress=" + saddress + ", stel=" + stel + ", scoordinate=" + scoordinate + ", scommerce="
				+ scommerce + ", sstate=" + sstate + ", sad=" + sad + ", sinfo=" + sinfo + ", ssort=" + ssort
				+ ", sbalancetype=" + sbalancetype + ", sbwx=" + sbwx + ", sbzfb=" + sbzfb + ", sbyhk=" + sbyhk
				+ ", slogo=" + slogo + ", styleimg=" + styleimg + ", number=" + number + ", number1=" + number1
				+ ", re=" + re + ", goods_shop=" + goods_shop + ", zone=" + zone + ", sc=" + sc + ", sb=" + sb + "]";
	}
}
