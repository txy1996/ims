package com.pydyun.ims.model;

import java.util.List;

import com.pydyun.ims.model.WxImages;

public class WxShopImages {



		private Integer sid;//商户id
		private Integer zid;//所在地区
//		private Integer bid;//品牌id
//		private Integer scid;//商户分类id
		private String sname;//商户名
		private String saddress;//地址
//		private String stel;//订餐联系方式（文本框50字）
		private String scoordinate;//经纬度（1,1）
//		private String scommerce;//商务洽谈联系方式
//		private Integer sstate;//营业状态（0开业，1暂停营业，2闭店）
//		private String syear;//装修年份
//		private String sstyle;//装修风格
//		private String slevel;//装修档次
//		private Integer scompartmentnum;//包间数量
		private Integer stcompartment;//当前可有约包间
		private String scompartmentinfo;//包间配套（棋牌、卫生间、茶歇、果盘、点心）
//		private String scompartmentmin;//包间最低消费
		private String smax;//接待能力（大堂100，包间10*10）
		private String smeetingplace;//会场配套说明（无 | 讲台、投影、大屏幕、音响、网络、电源）
		private String sad;//编辑推荐（广告词）
		private String sinfo;//商户简介（需要富文本）
//		private String ssmeetingplacemin;//会议餐标说明(比如会场免费用，餐标1000起)
//		private String ssort;//商户显示排序(分类:序号|分类:序号)
//		private Integer sbalancetype;//商户协议结算模式（1银行转账、2支付宝、3微信、4线下结算）
//		private String sbwx;//微信收款账号
//		private String sbzfb;//支付宝收款账号
//		private String sbyhk;//银行卡收款账号
		private WxAlbum wxalbum;
		private List<WxImages> wximages;
		public WxAlbum getWxalbum() {
			return wxalbum;
		}
		public void setWxalbum(WxAlbum wxalbum) {
			this.wxalbum = wxalbum;
		}
		public WxShopImages(WxAlbum wxalbum) {
			super();
			this.wxalbum = wxalbum;
		}
		public List<WxImages> getWximages() {
			return wximages;
		}
		public void setWximages(List<WxImages> wximages) {
			this.wximages = wximages;
		}
		public WxShopImages() {
	super();
}
		public WxShopImages(Integer sid, Integer zid, String sname,
				String saddress, String scoordinate, Integer stcompartment,
				String scompartmentinfo, String smax, String smeetingplace,
				String sad, String sinfo, List<WxImages> wximages) {
			super();
			this.sid = sid;
			this.zid = zid;
			this.sname = sname;
			this.saddress = saddress;
			this.scoordinate = scoordinate;
			this.stcompartment = stcompartment;
			this.scompartmentinfo = scompartmentinfo;
			this.smax = smax;
			this.smeetingplace = smeetingplace;
			this.sad = sad;
			this.sinfo = sinfo;
			this.wximages = wximages;
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
//		public Integer getBid() {
//			return bid;
//		}
//		public void setBid(Integer bid) {
//			this.bid = bid;
//		}
//		public Integer getScid() {
//			return scid;
//		}
//		public void setScid(Integer scid) {
//			this.scid = scid;
//		}
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
//		public String getStel() {
//			return stel;
//		}
//		public void setStel(String stel) {
//			this.stel = stel;
//		}
		public String getScoordinate() {
			return scoordinate;
		}
		public void setScoordinate(String scoordinate) {
			this.scoordinate = scoordinate;
		}
//		public String getScommerce() {
//			return scommerce;
//		}
//		public void setScommerce(String scommerce) {
//			this.scommerce = scommerce;
//		}
//		public Integer getSstate() {
//			return sstate;
//		}
//		public void setSstate(Integer sstate) {
//			this.sstate = sstate;
//		}
//		public String getSyear() {
//			return syear;
//		}
//		public void setSyear(String syear) {
//			this.syear = syear;
//		}
//		public String getSstyle() {
//			return sstyle;
//		}
//		public void setSstyle(String sstyle) {
//			this.sstyle = sstyle;
//		}
//		public String getSlevel() {
//			return slevel;
//		}
//		public void setSlevel(String slevel) {
//			this.slevel = slevel;
//		}
//		public Integer getScompartmentnum() {
//			return scompartmentnum;
//		}
//		public void setScompartmentnum(Integer scompartmentnum) {
//			this.scompartmentnum = scompartmentnum;
//		}
		public Integer getStcompartment() {
			return stcompartment;
		}
		public void setStcompartment(Integer stcompartment) {
			this.stcompartment = stcompartment;
		}
		public String getScompartmentinfo() {
			return scompartmentinfo;
		}
		public void setScompartmentinfo(String scompartmentinfo) {
			this.scompartmentinfo = scompartmentinfo;
		}
//		public String getScompartmentmin() {
//			return scompartmentmin;
//		}
//		public void setScompartmentmin(String scompartmentmin) {
//			this.scompartmentmin = scompartmentmin;
//		}
		public String getSmax() {
			return smax;
		}
		public void setSmax(String smax) {
			this.smax = smax;
		}
		public String getSmeetingplace() {
			return smeetingplace;
		}
		public void setSmeetingplace(String smeetingplace) {
			this.smeetingplace = smeetingplace;
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
//		public String getSsmeetingplacemin() {
//			return ssmeetingplacemin;
//		}
//		public void setSsmeetingplacemin(String ssmeetingplacemin) {
//			this.ssmeetingplacemin = ssmeetingplacemin;
//		}
//		public String getSsort() {
//			return ssort;
//		}
//		public void setSsort(String ssort) {
//			this.ssort = ssort;
//		}
//		public Integer getSbalancetype() {
//			return sbalancetype;
//		}
//		public void setSbalancetype(Integer sbalancetype) {
//			this.sbalancetype = sbalancetype;
//		}
//		public String getSbwx() {
//			return sbwx;
//		}
//		public void setSbwx(String sbwx) {
//			this.sbwx = sbwx;
//		}
//		public String getSbzfb() {
//			return sbzfb;
//		}
//		public void setSbzfb(String sbzfb) {
//			this.sbzfb = sbzfb;
//		}
//		public String getSbyhk() {
//			return sbyhk;
//		}
//		public void setSbyhk(String sbyhk) {
//			this.sbyhk = sbyhk;
//		}
		@Override
		public String toString() {
			return "WxShopImages [sid=" + sid + ", zid=" + zid + ", sname="
					+ sname + ", saddress=" + saddress + ", scoordinate="
					+ scoordinate + ", stcompartment=" + stcompartment
					+ ", scompartmentinfo=" + scompartmentinfo + ", sinfo="
					+ sinfo + ", wximages=" + wximages + "]";
		}

}

