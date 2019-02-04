package com.pydyun.ims.model;



public class WxProductRequest {
    private Integer id; //商品编号
    private Integer cid; //所属分类
    private String pname; //商品名称
    private Integer sid; //商家编号
    private String info; //商品详情
    private Integer price; //商品售价
    private Integer yprice; //优惠售价
    private String property; //商品属性
    private String ptitle; //商品副标题;若商品为场地则这个字段为场地面积;若商品属性为餐饮，则这个字段为人均价格.
    private String psad; //商品副标题;若商品为场地则这个字段为场地场地容纳人数,如果为课程或讲师则用作课程方向和适用人群
    private WxProductimg wximg;//商品对应图片
    private WxProductShop wxshop;//商品对应商户
    private WxLabel wxlabel;//标签
    private WxVoucherRequest wxvou;//代金券图片
    private WxProductClas wclas;
    private String sparefieldone;
    private String sparefieldtwo;
    private String sparefieldthree;
    private boolean collection;
    
	public boolean isCollection() {
		return collection;
	}
	public void setCollection(boolean collection) {
		this.collection = collection;
	}
	public String getSparefieldone() {
		return sparefieldone;
	}
	public void setSparefieldone(String sparefieldone) {
		this.sparefieldone = sparefieldone;
	}
	public String getSparefieldtwo() {
		return sparefieldtwo;
	}
	public void setSparefieldtwo(String sparefieldtwo) {
		this.sparefieldtwo = sparefieldtwo;
	}
	public String getSparefieldthree() {
		return sparefieldthree;
	}
	public void setSparefieldthree(String sparefieldthree) {
		this.sparefieldthree = sparefieldthree;
	}
	public WxProductClas getWclas() {
		return wclas;
	}
	public void setWclas(WxProductClas wclas) {
		this.wclas = wclas;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public WxVoucherRequest getWxvou() {
		return wxvou;
	}
	public void setWxvou(WxVoucherRequest wxvou) {
		this.wxvou = wxvou;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getPsad() {
		return psad;
	}
	public void setPsad(String psad) {
		this.psad = psad;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getYprice() {
		return yprice;
	}
	public void setYprice(Integer yprice) {
		this.yprice = yprice;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public WxProductShop getWxshop() {
		return wxshop;
	}
	public void setWxshop(WxProductShop wxshop) {
		this.wxshop = wxshop;
	}
	public WxLabel getWxlabel() {
		return wxlabel;
	}
	public void setWxlabel(WxLabel wxlabel) {
		this.wxlabel = wxlabel;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public WxProductimg getWximg() {
		return wximg;
	}
	public void setWximg(WxProductimg wximg) {
		this.wximg = wximg;
	}
}
