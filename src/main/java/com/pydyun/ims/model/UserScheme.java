package com.pydyun.ims.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserScheme 
 * @Description: TODO(用户自定义方案表,) 
 * @author tangxiaoyu 
 * @date 2018年8月10日 上午9:32:37 
 *
 */
public class UserScheme implements Serializable 
{

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */ 
    private static final long serialVersionUID = 1L;
    
    private Integer usid;//收藏ID
    private Integer usuid;//用户id
    private Integer ussid;//方案ID，如果用户是基于我们推荐的scheme表中的某个方案修改的就填写本字段，否则字段为空，表示用户自行设计添加的
    private String ustitle;//方案名字
    private String usinfo;//方案的简单说明，字数100
    private String usjson;//用户自定义的方案json字符串，具体格式，看文档附录一
    private Date usdate;//操作时间
    public Integer getUsid()
    {
        return usid;
    }
    public void setUsid(Integer usid)
    {
        this.usid = usid;
    }
    public Integer getUsuid()
    {
        return usuid;
    }
    public void setUsuid(Integer usuid)
    {
        this.usuid = usuid;
    }
    public Integer getUssid()
    {
        return ussid;
    }
    public void setUssid(Integer ussid)
    {
        this.ussid = ussid;
    }
   
    public String getUstitle()
    {
        return ustitle;
    }
    public void setUstitle(String ustitle)
    {
        this.ustitle = ustitle;
    }
    public String getUsinfo()
    {
        return usinfo;
    }
    public void setUsinfo(String usinfo)
    {
        this.usinfo = usinfo;
    }
    public String getUsjson()
    {
        return usjson;
    }
    public void setUsjson(String usjson)
    {
        this.usjson = usjson;
    }
    public Date getUsdate()
    {
        return usdate;
    }
    public void setUsdate(Date usdate)
    {
        this.usdate = usdate;
    }
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    
    
}
