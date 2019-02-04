package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: Label_scheme_sumResponse 
 * @Description: TODO(方案阶段所属标签返回封装类) 
 * @author tangxiaoyu 
 * @date 2018年8月2日 下午5:14:04 
 *
 */
public class Label_scheme_sumResponse implements Serializable
{

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */ 
    private static final long serialVersionUID = 1L;
    
    private Integer lssid;//主键id
    private Integer sid;//方案或阶段ID
    private Integer lid;//标签ID
    private Integer lstype;//是关联的方案还是方案中的阶段  0=方案，1=阶段
    private String lcinfo;//标签信息
    public Integer getLssid()
    {
        return lssid;
    }
    public void setLssid(Integer lssid)
    {
        this.lssid = lssid;
    }
    public Integer getSid()
    {
        return sid;
    }
    public void setSid(Integer sid)
    {
        this.sid = sid;
    }
    public Integer getLid()
    {
        return lid;
    }
    public void setLid(Integer lid)
    {
        this.lid = lid;
    }
    public Integer getLstype()
    {
        return lstype;
    }
    public void setLstype(Integer lstype)
    {
        this.lstype = lstype;
    }
    public String getLcinfo()
    {
        return lcinfo;
    }
    public void setLcinfo(String lcinfo)
    {
        this.lcinfo = lcinfo;
    }
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    

}
