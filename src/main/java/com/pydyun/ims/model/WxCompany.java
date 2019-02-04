package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: WxCompany
 * @Description: TODO(微信:个人中心-发票管理)
 * @author tangxiaoyu
 * @date 2018年8月10日 下午3:36:45
 *
 */
public class WxCompany implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer cid;// 公司ID
    private Integer zid;// 所属地区ID
    private String cname;// 机构名
    private Integer cgeneral_taxpayer;// 是否一般纳税人0是，1否
    private String cidentify;// 纳税人识别号
    private String ccode;// 统一社会信用代码
    private String caddress;// 注册地址
    private String cbank;// 开户银行
    private String caccount;// 开户账号
    private String ctel;// 办公联系电话
    private String cinfo;// 公司简介
    public Integer getCid()
    {
        return cid;
    }
    public void setCid(Integer cid)
    {
        this.cid = cid;
    }
    public Integer getZid()
    {
        return zid;
    }
    public void setZid(Integer zid)
    {
        this.zid = zid;
    }
    public String getCname()
    {
        return cname;
    }
    public void setCname(String cname)
    {
        this.cname = cname;
    }
    public Integer getCgeneral_taxpayer()
    {
        return cgeneral_taxpayer;
    }
    public void setCgeneral_taxpayer(Integer cgeneral_taxpayer)
    {
        this.cgeneral_taxpayer = cgeneral_taxpayer;
    }
    public String getCidentify()
    {
        return cidentify;
    }
    public void setCidentify(String cidentify)
    {
        this.cidentify = cidentify;
    }
    public String getCcode()
    {
        return ccode;
    }
    public void setCcode(String ccode)
    {
        this.ccode = ccode;
    }
    public String getCaddress()
    {
        return caddress;
    }
    public void setCaddress(String caddress)
    {
        this.caddress = caddress;
    }
    public String getCbank()
    {
        return cbank;
    }
    public void setCbank(String cbank)
    {
        this.cbank = cbank;
    }
    public String getCaccount()
    {
        return caccount;
    }
    public void setCaccount(String caccount)
    {
        this.caccount = caccount;
    }
    public String getCtel()
    {
        return ctel;
    }
    public void setCtel(String ctel)
    {
        this.ctel = ctel;
    }
    public String getCinfo()
    {
        return cinfo;
    }
    public void setCinfo(String cinfo)
    {
        this.cinfo = cinfo;
    }
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    

}
