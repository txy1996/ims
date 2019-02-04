package com.pydyun.ims.model;

public class PromotionRequest {
	private String url;// 图片地址
	private String words;// 前台文字显示
	private String marking;// 前台标示显示，如S:商户详情,F:方案详情,P:产品详情	,LS:商户列表,LF:方案列表,LP:产品列表
	private String address;// 前台地址显示
	
	public String getMarking() {
		return marking;
	}
	public void setMarking(String marking) {
		this.marking = marking;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
