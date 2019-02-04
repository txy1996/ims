package com.pydyun.ims.model;

import java.util.List;

/**
 * @ClassName: Scheme_shop 
 * @Description: TODO(方案所含商家列表) 
 * @author tangxiaoyu 
 * @date 2018年7月18日 上午9:13:39 
 *
 */
public class Scheme_shop {
	private int sssid;
	private int shopid;
	private int ssid;
	private int ssort;
	private String ssad;
	private String ssimgs;
	private String sreplace;
	private StageIo stageIo;//关联阶段信息
	private List<Shop> shop;
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
	public String getSsad() {
		return ssad;
	}
	public void setSsad(String ssad) {
		this.ssad = ssad;
	}
	public StageIo getStageIo() {
		return stageIo;
	}
	public void setStageIo(StageIo stageIo) {
		this.stageIo = stageIo;
	}
	public List<Shop> getShop() {
		return shop;
	}
	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
	
}
