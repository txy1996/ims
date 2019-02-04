package com.pydyun.ims.model;

import java.util.Date;

public class WxProductimg {
	private Integer id;//图片id
    private Integer pid;//图片所属商品id
    private String url;//图片地址
    private Integer tfimg;//是否是图片 0=图片,1=视频，2=嵌入式网页
    private String name;//图片名字
    private Date updata;//上传时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getTfimg() {
		return tfimg;
	}
	public void setTfimg(Integer tfimg) {
		this.tfimg = tfimg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUpdata() {
		return updata;
	}
	public void setUpdata(Date updata) {
		this.updata = updata;
	}
    
}
