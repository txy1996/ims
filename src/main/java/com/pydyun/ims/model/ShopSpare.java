package com.pydyun.ims.model;

/**
 * @ClassName: ShopSpare
 * @Description: TODO(由于商户表改动临时创建的基础类 )
 * @author tangxiaoyu
 * @date 2018年7月20日 上午11:09:40
 *
 */
public class ShopSpare
{

    private Integer sid;// 商户id
    private Integer zid;// 所在地区
    private Integer bid;// 品牌id
    private Integer scid;// 商户分类id
    private String sname;// 商户名
    private String saddress;// 地址
    private String stel;// 订餐联系方式（文本框50字）
    private String scoordinate;// 经纬度（1,1）
    private String scommerce;// 商务洽谈联系方式
    private Integer sstate;// 营业状态（0开业，1暂停营业，2闭店）
    private String sad;// 编辑推荐（广告词）
    private String sinfo;// 商户简介（需要富文本）
    private String ssort;// 商户显示排序(分类:序号|分类:序号)
    private Integer sbalancetype;// 商户协议结算模式（1银行转账、2支付宝、3微信、4线下结算）
    private String sbwx;// 微信收款账号
    private String sbzfb;// 支付宝收款账号
    private String sbyhk;// 银行卡收款账号
    private String slogo;// 商户标志
    private String styleimg;// 商户正在前台展示的，从商户自有相册中选择出来的形象展示图片，多张图片之间用逗号隔开，
    public Integer getSid()
    {
        return sid;
    }
    public void setSid(Integer sid)
    {
        this.sid = sid;
    }
    public Integer getZid()
    {
        return zid;
    }
    public void setZid(Integer zid)
    {
        this.zid = zid;
    }
    public Integer getBid()
    {
        return bid;
    }
    public void setBid(Integer bid)
    {
        this.bid = bid;
    }
    public Integer getScid()
    {
        return scid;
    }
    public void setScid(Integer scid)
    {
        this.scid = scid;
    }
    public String getSname()
    {
        return sname;
    }
    public void setSname(String sname)
    {
        this.sname = sname;
    }
    public String getSaddress()
    {
        return saddress;
    }
    public void setSaddress(String saddress)
    {
        this.saddress = saddress;
    }
    public String getStel()
    {
        return stel;
    }
    public void setStel(String stel)
    {
        this.stel = stel;
    }
    public String getScoordinate()
    {
        return scoordinate;
    }
    public void setScoordinate(String scoordinate)
    {
        this.scoordinate = scoordinate;
    }
    public String getScommerce()
    {
        return scommerce;
    }
    public void setScommerce(String scommerce)
    {
        this.scommerce = scommerce;
    }
    public Integer getSstate()
    {
        return sstate;
    }
    public void setSstate(Integer sstate)
    {
        this.sstate = sstate;
    }
    public String getSad()
    {
        return sad;
    }
    public void setSad(String sad)
    {
        this.sad = sad;
    }
    public String getSinfo()
    {
        return sinfo;
    }
    public void setSinfo(String sinfo)
    {
        this.sinfo = sinfo;
    }
    public String getSsort()
    {
        return ssort;
    }
    public void setSsort(String ssort)
    {
        this.ssort = ssort;
    }
    public Integer getSbalancetype()
    {
        return sbalancetype;
    }
    public void setSbalancetype(Integer sbalancetype)
    {
        this.sbalancetype = sbalancetype;
    }
    public String getSbwx()
    {
        return sbwx;
    }
    public void setSbwx(String sbwx)
    {
        this.sbwx = sbwx;
    }
    public String getSbzfb()
    {
        return sbzfb;
    }
    public void setSbzfb(String sbzfb)
    {
        this.sbzfb = sbzfb;
    }
    public String getSbyhk()
    {
        return sbyhk;
    }
    public void setSbyhk(String sbyhk)
    {
        this.sbyhk = sbyhk;
    }
    public String getSlogo()
    {
        return slogo;
    }
    public void setSlogo(String slogo)
    {
        this.slogo = slogo;
    }
    public String getStyleimg()
    {
        return styleimg;
    }
    public void setStyleimg(String styleimg)
    {
        this.styleimg = styleimg;
    }
    
    

}
