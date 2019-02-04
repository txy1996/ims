package com.pydyun.ims.model;

import org.springframework.web.multipart.MultipartFile;

public class StageShop {
	private int sssid;
	private int shopid; //商户ID
	private int ssid;	//所属方案阶段ID
	private Integer ssort;
	private String ssad;
	private String ssimgs;
	private String sreplace;
	private Shop shop;
	private Stage stage;
	private MultipartFile  file;
	public int getSssid() {
		return sssid;
	}
	public void setSssid(int sssid) {
		this.sssid = sssid;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getSsid() {
		return ssid;
	}
	public void setSsid(int ssid) {
		this.ssid = ssid;
	}

	public Integer getSsort() {
		return ssort;
	}
	public void setSsort(Integer ssort) {
		this.ssort = ssort;
	}
	public String getSsad() {
		return ssad;
	}
	public void setSsad(String ssad) {
		this.ssad = ssad;
	}
	public String getSsimgs() {
		return ssimgs;
	}
	public void setSsimgs(String ssimgs) {
		this.ssimgs = ssimgs;
	}
	public String getSreplace() {
		return sreplace;
	}
	public void setSreplace(String sreplace) {
		this.sreplace = sreplace;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
