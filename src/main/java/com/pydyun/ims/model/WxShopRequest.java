package com.pydyun.ims.model;

public class WxShopRequest {
		private Integer sid;//商户id
		private Integer scid; //商户分类ID
		private String sname;//商户名
		private String sinfo;//商户简介（需要富文本）
		private String slogo;//商户形象图片，可以是LOGO，也可以是门头
		private WxLabel wxlabel;//标签
		private Label_shop_sum label_shop_sum;
		
		public Label_shop_sum getLabel_shop_sum() {
			return label_shop_sum;
		}
		public void setLabel_shop_sum(Label_shop_sum label_shop_sum) {
			this.label_shop_sum = label_shop_sum;
		}
		public WxLabel getWxlabel() {
			return wxlabel;
		}
		public void setWxlabel(WxLabel wxlabel) {
			this.wxlabel = wxlabel;
		}
		public Integer getScid() {
			return scid;
		}
		public void setScid(Integer scid) {
			this.scid = scid;
		}
		public String getSlogo() {
			return slogo;
		}
		public void setSlogo(String slogo) {
			this.slogo = slogo;
		}
		public Integer getSid() {
			return sid;
		}
		public void setSid(Integer sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getSinfo() {
			return sinfo;
		}
		public void setSinfo(String sinfo) {
			this.sinfo = sinfo;
		}
		
	}

