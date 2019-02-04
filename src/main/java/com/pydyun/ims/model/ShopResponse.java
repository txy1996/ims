package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: ShopResponse 
 * @Description: TODO(商家模糊查询返回封装类) 
 * @author tangxiaoyu 
 * @date 2018年7月18日 下午5:21:52 
 *
 */
public class ShopResponse implements Serializable
{

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */ 
    private static final long serialVersionUID = 1L;
    
    private Integer sid;//商户id
    private String sname;//商户名
    private String sad;//编辑推荐（广告词）
    private String sinfo;//商户简介（需要富文本）
    public Integer getSid()
    {
        return sid;
    }
    public void setSid(Integer sid)
    {
        this.sid = sid;
    }
    public String getSname()
    {
        return sname;
    }
    public void setSname(String sname)
    {
        this.sname = sname;
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
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    

}
