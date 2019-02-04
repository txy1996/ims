package com.pydyun.ims.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class WxProduct {
	private Integer id;// 商品编号
    private String pname;// 商品名称
    private Integer cid;// 所属分类
    private Integer sid;// 商家编号
    private Integer spunum;// 销量
    private Integer stock;// 库存
    private String pcode;// 商品编号
    private String property;// 商品属性表 property 的ID序列 例如 [1:1,2:3]
    private Double price;// 售价(原价)
    private Double yprice;// 优惠售价
    private String info;// 商品详情
    private Integer state;// 商品状态 0=未上架，1=上架，2=下架，3=？？
    private String ptitle;// 副标题， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private String psad;// 商品广告词， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private Integer pxd;//本产品是否想允许使用优惠券、代金券 0=不限制，都可以用 1=不适用优惠券，但可以使用代金券 2=不适用代金券，但可以使用优惠券 12=两种券都不允许
    private Double freight;//商品的运费，首重/首件.
    private Double fg_xf;//续费，从第二件开始的续费，比如每增加一件就多二元钱
    private Integer fg_type;//运费计价方式0=按单计算，则无论买多少，运费都不变1=多件续费，比如首件10元，续费2元用户购买3件的计算公式为 10+2*3
    private Date stime;//注册时间
    private Date sutime;//最近一次更新时间
    private String sname;
    private String slogo;
    private WxProduct pro;
	private WxProductimg proimg;
	private List<WxProduct> shop;//tuijian
	private WxProduct pro1;//taocan
	private Set<WxUser_assess> set;//pinglun
	private List<WxLabel> labe;//biaoqian
	private WxLabel wxlabel;
	private boolean collection; //用于判断此商品是否被收藏
	private List<String> propertylist;
	
	public String getSlogo() {
		return slogo;
	}
	public void setSlogo(String slogo) {
		this.slogo = slogo;
	}
	public List<String> getPropertylist() {
		return propertylist;
	}
	public void setPropertylist(List<String> propertylist) {
		this.propertylist = propertylist;
	}
	public boolean isCollection() {
		return collection;
	}
	public void setCollection(boolean collection) {
		this.collection = collection;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPsad() {
		return psad;
	}
	public void setPsad(String psad) {
		this.psad = psad;
	}
	public Integer getPxd() {
		return pxd;
	}
	public void setPxd(Integer pxd) {
		this.pxd = pxd;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Double getFg_xf() {
		return fg_xf;
	}
	public void setFg_xf(Double fg_xf) {
		this.fg_xf = fg_xf;
	}
	public Integer getFg_type() {
		return fg_type;
	}
	public void setFg_type(Integer fg_type) {
		this.fg_type = fg_type;
	}
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
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPasd() {
		return psad;
	}
	public void setPasd(String psad) {
		this.psad = psad;
	}
	public WxLabel getWxlabel() {
		return wxlabel;
	}
	public void setWxlabel(WxLabel wxlabel) {
		this.wxlabel = wxlabel;
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
	public List<WxProduct> getShop() {
		return shop;
	}
	public void setShop(List<WxProduct> shop) {
		this.shop = shop;
	}
	public WxProduct getPro1() {
		return pro1;
	}
	public void setPro1(WxProduct pro1) {
		this.pro1 = pro1;
	}
	public Set<WxUser_assess> getSet() {
		return set;
	}
	public void setSet(Set<WxUser_assess> set) {
		this.set = set;
	}
	public List<WxLabel> getLabe() {
		return labe;
	}
	public void setLabe(List<WxLabel> labe) {
		this.labe = labe;
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
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getSpunum() {
		return spunum;
	}
	public void setSpunum(Integer spunum) {
		this.spunum = spunum;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getYprice() {
		return yprice;
	}
	public void setYprice(Double yprice) {
		this.yprice = yprice;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
    
}
