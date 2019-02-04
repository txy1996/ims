package com.pydyun.ims.model;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public class Coupon {
	private Integer cid;//券id
	private Integer ccid;//优惠券分类id
	private String  csdate;//有效期起
	private String codate;//有效期止
	private String crange;//适用商户（全站all、品牌p:1,2,3、单店s：1，2,3），不可将品牌、店铺做混合插入
	private String cdiscount;//折扣率(88.88)
	private String csum;//金额(50) 
	private String cfullcut;//满减[100,10] 
	private Integer cisood;//是否找零 0否，1是
	private Integer cintegration;//成长度数量(本券可以赠送积分，也可以抵扣积分)
	private String cmoney;//优惠券进货价，商家卖给平台的价格
	private String cprice;//优惠券销售价
	private Integer cgoods;//购买本券所需要金币数量(本券可以赠送金币，也可以抵扣金币，作为销售价以一定要是负)
	private String cimg;//优惠券图片
	private String ctitle;//优惠券名字
	private String cinfo;//优惠券介绍
	private String crefund;//过期处理方法，是否退款
	private Integer cisrepeat;//用户是否可以重复领取本券，数字为重复领取数量，1就只能是一张，10就是可以领取10张
	private Integer uaid;//谁谈下来的这个优惠券，默认0为系统，大于零为adminusers表主键
	private Adminusers adminusers;//公司服务人员表
	private Integer cnum;
	private Integer cstore;
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
	public Integer getCnum() {
		return cnum;
	}
	public void setCnum(Integer cnum) {
		this.cnum = cnum;
	}
	public Integer getCstore() {
		return cstore;
	}
	public void setCstore(Integer cstore) {
		this.cstore = cstore;
	}
	private MultipartFile file;
	private Couponclass couponclass;
	private Integer crid;
	
	public Integer getCrid() {
		return crid;
	}
	public void setCrid(Integer crid) {
		this.crid = crid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCcid() {
		return ccid;
	}
	public void setCcid(Integer ccid) {
		this.ccid = ccid;
	}
	public String getCsdate() {
		return csdate;
	}
	public void setCsdate(String csdate) {
		this.csdate = csdate;
	}
	public String getCodate() {
		return codate;
	}
	public void setCodate(String codate) {
		this.codate = codate;
	}
	public String getCrange() {
		return crange;
	}
	public void setCrange(String crange) {
		this.crange = crange;
	}
	public String getCdiscount() {
		return cdiscount;
	}
	public void setCdiscount(String cdiscount) {
		this.cdiscount = cdiscount;
	}
	public String getCsum() {
		return csum;
	}
	public void setCsum(String csum) {
		this.csum = csum;
	}
	public String getCfullcut() {
		return cfullcut;
	}
	public void setCfullcut(String cfullcut) {
		this.cfullcut = cfullcut;
	}
	public Integer getCisood() {
		return cisood;
	}
	public void setCisood(Integer cisood) {
		this.cisood = cisood;
	}
	public Integer getCintegration() {
		return cintegration;
	}
	public void setCintegration(Integer cintegration) {
		this.cintegration = cintegration;
	}
	public String getCmoney() {
		return cmoney;
	}
	public void setCmoney(String cmoney) {
		this.cmoney = cmoney;
	}
	public String getCprice() {
		return cprice;
	}
	public void setCprice(String cprice) {
		this.cprice = cprice;
	}
	public Integer getCgoods() {
		return cgoods;
	}
	public void setCgoods(Integer cgoods) {
		this.cgoods = cgoods;
	}
	public String getCimg() {
		return cimg;
	}
	public void setCimg(String cimg) {
		this.cimg = cimg;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public String getCinfo() {
		return cinfo;
	}
	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}
	public String getCrefund() {
		return crefund;
	}
	public void setCrefund(String crefund) {
		this.crefund = crefund;
	}
	public Integer getCisrepeat() {
		return cisrepeat;
	}
	public void setCisrepeat(Integer cisrepeat) {
		this.cisrepeat = cisrepeat;
	}
	public Integer getUaid() {
		return uaid;
	}
	public void setUaid(Integer uaid) {
		this.uaid = uaid;
	}
	public Adminusers getAdminusers() {
		return adminusers;
	}
	public void setAdminusers(Adminusers adminusers) {
		this.adminusers = adminusers;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Couponclass getCouponclass() {
		return couponclass;
	}
	public void setCouponclass(Couponclass couponclass) {
		this.couponclass = couponclass;
	} 
	

}
