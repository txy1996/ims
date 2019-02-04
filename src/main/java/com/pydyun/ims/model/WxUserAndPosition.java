package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: WxUserAndPosition
 * @Description: TODO(用户和公司关系表)
 * @author tangxiaoyu
 * @date 2018年8月10日 下午5:13:41
 *
 */
public class WxUserAndPosition implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer upid;// 关系ID
    private Integer urid;// 用户ID
    private Integer cid;// 公司ID
    private Integer pid;// 职位头衔ID
    private Integer upsort;// 排序
    private Integer upsdate;// 添加时间
    private Integer upodate;// 最后一次修改时间

    public Integer getUpid()
    {
        return upid;
    }

    public void setUpid(Integer upid)
    {
        this.upid = upid;
    }

    public Integer getUrid()
    {
        return urid;
    }

    public void setUrid(Integer urid)
    {
        this.urid = urid;
    }

    public Integer getCid()
    {
        return cid;
    }

    public void setCid(Integer cid)
    {
        this.cid = cid;
    }

    public Integer getPid()
    {
        return pid;
    }

    public void setPid(Integer pid)
    {
        this.pid = pid;
    }

    public Integer getUpsort()
    {
        return upsort;
    }

    public void setUpsort(Integer upsort)
    {
        this.upsort = upsort;
    }

    public Integer getUpsdate()
    {
        return upsdate;
    }

    public void setUpsdate(Integer upsdate)
    {
        this.upsdate = upsdate;
    }

    public Integer getUpodate()
    {
        return upodate;
    }

    public void setUpodate(Integer upodate)
    {
        this.upodate = upodate;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

}
