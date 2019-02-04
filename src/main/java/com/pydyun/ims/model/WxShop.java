package com.pydyun.ims.model;

import java.util.List;

import com.pydyun.ims.model.WxImages;


public class WxShop {
	private Integer sid;//商户id
	private Integer zid;//所在地区
	private Integer scid; //商户分类ID
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	private String sname;//商户名
	private String saddress;//地址
	private String scoordinate;//经纬度（1,1）
	private String sad;//编辑推荐（广告词）
	private String stel;//编辑推荐（广告词）
	private String sinfo;//商户简介（需要富文本）
	private String slogo;//商户形象图片，可以是LOGO，也可以是门头
	private String styleimg;
	private WxImages wximages;
	private WxLabel wxlabel;
	private WxAlbum wxalbum;
	private Label_shop_sum label_shop_sum;
	private WxProduct pro;
	private WxProductimg proimg;
	private List<WxImages> Images;
	private boolean collection;
	
	
	public boolean isCollection() {
		return collection;
	}
	public void setCollection(boolean collection) {
		this.collection = collection;
	}
	public WxLabel getWxlabel() {
		return wxlabel;
	}
	public void setWxlabel(WxLabel wxlabel) {
		this.wxlabel = wxlabel;
	}
	public WxAlbum getWxalbum() {
		return wxalbum;
	}
	public void setWxalbum(WxAlbum wxalbum) {
		this.wxalbum = wxalbum;
	}
	public Label_shop_sum getLabel_shop_sum() {
		return label_shop_sum;
	}
	public void setLabel_shop_sum(Label_shop_sum label_shop_sum) {
		this.label_shop_sum = label_shop_sum;
	}
	public WxProduct getPro() {
		return pro;
	}
	public void setPro(WxProduct pro) {
		this.pro = pro;
	}
	public WxProductimg getProimg() {
		return proimg;
	}
	public void setProimg(WxProductimg proimg) {
		this.proimg = proimg;
	}
	public List<WxImages> getImages() {
		return Images;
	}
	public void setImages(List<WxImages> images) {
		Images = images;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
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
	public WxImages getWximages() {
		return wximages;
	}
	public void setWximages(WxImages wximages) {
		this.wximages = wximages;
	}
	public WxShop(WxImages wximages) {
		super();
		this.wximages = wximages;
	}
	public WxShop() {
		super();
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
	public String getScoordinate() {
		return scoordinate;
	}
	public void setScoordinate(String scoordinate) {
		this.scoordinate = scoordinate;
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
	
}
