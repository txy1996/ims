 package com.pydyun.ims.model;
public class Promotion {
	private Integer id;
	private Integer ptype;// 0=图片广告、1=文字广告、2=视频广告、3=纯文字列表、4=图文列表
	private String pzone;// 位置标题，比如 index页顶部， shoplist页竖向第二栏右
	private String psource;// 数据源，注意后面格式说明  图片+文字+链接，格式=I:imgurl#text#url
							//  图片+链接，格式=I:imgurl#url   , 纯文字+链接  格式=
							//  T：text#url   ， 纯文字店铺列表，格式   LST:1,2,3   纯文字方案列表
							// 格式为 LFT：1,2,3   纯文字产品ID  LPT：1,2,3,4,5
							//       ，图文列表的店铺为  LS:1,2,3,4    图文列表的方案为
							// LF:1,2,3,4    图文列表的产品为  LP:1,23,4
	private String pinfo;// 附加说明
	private String sdate;// 生效日期
	private String odate;// 失效日期
	private Integer state;// 状态 0=预审，1=发布，2=下架， 这个和日期的有效期可以组合使用。
							// 即便在有效期内，也可以是未发布或者强制下架
	private String pdate; // 添加日期

	private PromotionRequest promot;



	public PromotionRequest getPromot() {
		return promot;
	}

	public void setPromot(PromotionRequest promot) {
		this.promot = promot;
	}

	public Integer getPtype() {
		return ptype;
	}

	public void setPtype(Integer ptype) {
		this.ptype = ptype;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Promotion(Integer id) {
		super();
		this.id = id;
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

	public Promotion() {
		super();
	}

	public Promotion( Integer ptype, String pzone, String psource,
			String pinfo, String sdate, String odate, Integer state,
			String pdate) {
		super();
		this.ptype = ptype;
		this.pzone = pzone;
		this.psource = psource;
		this.pinfo = pinfo;
		this.sdate = sdate;
		this.odate = odate;
		this.state = state;
		this.pdate = pdate;
	}

	
}
