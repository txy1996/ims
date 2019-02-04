package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: GoogAndIntegrationItem
 * @Description: TODO(金币积分操作项)
 * @author tangxiaoyu
 * @date 2018年7月14日 下午4:20:55
 *
 */
public class GoogAndIntegrationItem implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer id;// 操作项id
    private String iname;// 操作项名称
    private Integer inum;// 操作数量
    private Long igori;// 金币还是积分0=积分,1=金币
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getIname()
    {
        return iname;
    }
    public void setIname(String iname)
    {
        this.iname = iname;
    }
    public Integer getInum()
    {
        return inum;
    }
    public void setInum(Integer inum)
    {
        this.inum = inum;
    }
    public Long getIgori()
    {
        return igori;
    }
    public void setIgori(Long igori)
    {
        this.igori = igori;
    }
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    @Override
    public String toString()
    {
        return "GoogAndIntegrationItem [id=" + id + ", iname=" + iname + ", inum=" + inum + ", igori=" + igori + "]";
    }

    

}
