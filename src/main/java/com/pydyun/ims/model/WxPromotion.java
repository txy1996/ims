package com.pydyun.ims.model;

public class WxPromotion {
	private Integer Id;
	private Integer Ptype; //1=图片文字链接、2=图片链接、3=文字链接、4=视频链接、5=纯文字商户列表、6=纯文字方案列表、7=纯文字商品列表、
	                       //8=图文商户列表、9=图文方案列表、10=图文商品列表、11=商户纯图片列表、12=方案纯图片列表、13=商品纯图片列表
	private String pzone;// 位置标题，比如 index页顶部， shoplist页竖向第二栏右
	private String psource;//数据源，注意后面格式说明  图片文字链接(TWD:imgurl#text#url)、图片链接(TD:imgurl#url)、文字链接(WD:text#url)、
	                       //视频链接(SD:video#url)、纯文字商户列表(CSH:1,2,3)、纯文字方案列表(CFN:1,2,3)、纯文字商品列表(CSP:1,2,3)、
	                       //图文商户列表(TSh:1,2,3)、图文方案列表(TFN:1,2,3)、图文商品列表(TSP:1,2,3)、商户纯图片列表(CTP:1,2,3)、
	                       //方案纯图片列表(CTFN:1,2,3)、商品纯图片列表(CTSP:1,2,3)
	private String pinfo;// 附加说明
	private String sdate;// 生效日期
	private String odate;// 失效日期
	private Integer state;// 状态 0=预审，1=发布，2=下架， 这个和日期的有效期可以组合使用。
							// 即便在有效期内，也可以是未发布或者强制下架
	private String pdate;// 添加日期

	public WxPromotion() {
		super();
	}

	public WxPromotion(Integer id, Integer ptype, String pzone, String psource,
			String pinfo, String sdate, String odate, Integer state,
			String pdate) {
		super();
		Id = id;
		Ptype = ptype;
		this.pzone = pzone;
		this.psource = psource;
		this.pinfo = pinfo;
		this.sdate = sdate;
		this.odate = odate;
		this.state = state;
		this.pdate = pdate;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getPtype() {
		return Ptype;
	}

	public void setPtype(Integer ptype) {
		Ptype = ptype;
	}

	public String getPzone() {
		return pzone;
	}

	public void setPzone(String pzone) {
		this.pzone = pzone;
	}

	public String getPsource() {
		return psource;
	}

	public void setPsource(String psource) {
		this.psource = psource;
	}

	public String getPinfo() {
		return pinfo;
	}

	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "WxPromotion [psource=" + psource + "]";
	}

	

}
