package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: WxPosition
 * @Description: TODO(职位头衔)
 * @author tangxiaoyu
 * @date 2018年8月10日 下午5:09:39
 *
 */
public class WxPosition implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer pid;// 职位头衔ID
    private String pname;// 职位名
    private String pinfo;// 职位说明
    public Integer getPid()
    {
        return pid;
    }
    public void setPid(Integer pid)
    {
        this.pid = pid;
    }
    public String getPname()
    {
        return pname;
    }
    public void setPname(String pname)
    {
        this.pname = pname;
    }
    public String getPinfo()
    {
        return pinfo;
    }
    public void setPinfo(String pinfo)
    {
        this.pinfo = pinfo;
    }
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    

}
