package com.pydyun.ims.model;

//import java.util.List;

public class WxPromotionRequest {
	private String imgurl;//广告图片的路径
	private String info;//广告的描述文字
	private String jumpurl;//广告跳转的地址       
	private String name;//广告的名字或者商品的名字
	private Integer fid;//广告分类id
//	private List<WxPromotionRequest> list; //广告页面顶部
//	private WxPromotionRequest  req1; //第二栏
//	private WxPromotionRequest  req2; //第三栏
//	private WxPromotionRequest  req3; //广告页面底部上
//	private WxPromotionRequest  req4; //广告页面底部左
//	private WxPromotionRequest  req5; //广告页面底部右
	
public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	//	public WxPromotionRequest getReq5() {
//		return req5;
//	}
//	public void setReq5(WxPromotionRequest req5) {
//		this.req5 = req5;
//	}
//	public List<WxPromotionRequest> getList() {
//		return list;
//	}
//	public void setList(List<WxPromotionRequest> list) {
//		this.list = list;
//	}
//	public WxPromotionRequest getReq1() {
//		return req1;
//	}
//	public void setReq1(WxPromotionRequest req1) {
//		this.req1 = req1;
//	}
//	public WxPromotionRequest getReq2() {
//		return req2;
//	}
//	public void setReq2(WxPromotionRequest req2) {
//		this.req2 = req2;
//	}
//	public WxPromotionRequest getReq3() {
//		return req3;
//	}
//	public void setReq3(WxPromotionRequest req3) {
//		this.req3 = req3;
//	}
//	public WxPromotionRequest getReq4() {
//		return req4;
//	}
//	public void setReq4(WxPromotionRequest req4) {
//		this.req4 = req4;
//	}
	public String getImgurl() {
		return imgurl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getJumpurl() {
		return jumpurl;
	}
	public void setJumpurl(String jumpurl) {
		this.jumpurl = jumpurl;
	}
	
}
