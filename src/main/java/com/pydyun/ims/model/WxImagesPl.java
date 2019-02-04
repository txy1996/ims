package com.pydyun.ims.model;

import java.util.Date;

/**
 * 评论相片表
 * @author fy
 *
 */
public class WxImagesPl {
	private Integer iid;//相片id
	private Integer plid;//评论id
	private String iurl;//资源地址
	private Date idate;//上传时间
	private Integer tfimg;//是否是图片 0=图片,1=视频，2=嵌入式网页
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public Integer getPlid() {
		return plid;
	}
	public void setPlid(Integer plid) {
		this.plid = plid;
	}
	public String getIurl() {
		return iurl;
	}
	public void setIurl(String iurl) {
		this.iurl = iurl;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public Integer getTfimg() {
		return tfimg;
	}
	public void setTfimg(Integer tfimg) {
		this.tfimg = tfimg;
	}
	
}
