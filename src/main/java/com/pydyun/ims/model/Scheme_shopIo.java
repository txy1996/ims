package com.pydyun.ims.model;

import java.util.List;

public class Scheme_shopIo {
	private int sssid;
	private int shopid;
	private int ssid;
	private int ssort;
	private String ssad;
	private String ssimgs;
	private String sreplace;
	private List<Shop> shop;
	private List<Scheme_stage> scheme_stage;
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
	public int getSsort() {
		return ssort;
	}
	public void setSsort(int ssort) {
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
	public List<Shop> getShop() {
		return shop;
	}
	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
	public List<Scheme_stage> getScheme_stage() {
		return scheme_stage;
	}
	public void setScheme_stage(List<Scheme_stage> scheme_stage) {
		this.scheme_stage = scheme_stage;
	}
	
}
