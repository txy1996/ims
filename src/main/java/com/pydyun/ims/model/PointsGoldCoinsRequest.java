package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: PointsGoldCoinsRequest
 * @Description: TODO(用户积分金币查询封装类)
 * @author tangxiaoyu
 * @date 2018年7月9日 下午3:12:50
 *
 */
public class PointsGoldCoinsRequest implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private String username;// 用户名称
    private String sname;// 商户名称
    private Integer urid;// 拥有该金币用户ID
    private Integer sid;// 商户id
    private String goinfo;// 操作原因
    private String starttime;// 开始时间
    private String endtime;

    public String getSname()
    {
        return sname;
    }

    public void setSname(String sname)
    {
        this.sname = sname;
    }

    public Integer getSid()
    {
        return sid;
    }

    public void setSid(Integer sid)
    {
        this.sid = sid;
    }

    public Integer getUrid()
    {
        return urid;
    }

    public void setUrid(Integer urid)
    {
        this.urid = urid;
    }

    public String getGoinfo()
    {
        return goinfo;
    }

    public void setGoinfo(String goinfo)
    {
        this.goinfo = goinfo;
    }

    public String getStarttime()
    {
        return starttime;
    }

    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }

    public String getEndtime()
    {
        return endtime;
    }

    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "PointsGoldCoinsRequest [username=" + username + ", urid=" + urid + ", goinfo=" + goinfo + ", starttime="
                + starttime + ", endtime=" + endtime + "]";
    }

}
