package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: WxOrderPay
 * @Description: TODO(微信:订单支付)
 * @author tangxiaoyu
 * @date 2018年8月23日 上午10:20:22
 *
 */
public class WxOrderPay implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer id;// 记录ID
    private Integer oid;// 所属订单ID
    private Double sumprice;// 总金额
    private Double price;// 实际支付现金
    private Integer cid;// 所用优惠券的ID
    private Double cprice;// 优惠券抵扣的金额
    private Integer vid;// 所使用代金券ID
    private Double vprice;// 代金券抵扣掉的金额
    private Integer goodnum;// 所使用金币数量
    private Double gprice;// 金币抵扣的金额
    private String optime;// 具体支付时间
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public Integer getOid()
    {
        return oid;
    }
    public void setOid(Integer oid)
    {
        this.oid = oid;
    }
    public Double getSumprice()
    {
        return sumprice;
    }
    public void setSumprice(Double sumprice)
    {
        this.sumprice = sumprice;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
    public Integer getCid()
    {
        return cid;
    }
    public void setCid(Integer cid)
    {
        this.cid = cid;
    }
    public Double getCprice()
    {
        return cprice;
    }
    public void setCprice(Double cprice)
    {
        this.cprice = cprice;
    }
    public Integer getVid()
    {
        return vid;
    }
    public void setVid(Integer vid)
    {
        this.vid = vid;
    }
    public Double getVprice()
    {
        return vprice;
    }
    public void setVprice(Double vprice)
    {
        this.vprice = vprice;
    }
    public Integer getGoodnum()
    {
        return goodnum;
    }
    public void setGoodnum(Integer goodnum)
    {
        this.goodnum = goodnum;
    }
    public Double getGprice()
    {
        return gprice;
    }
    public void setGprice(Double gprice)
    {
        this.gprice = gprice;
    }
    public String getOptime()
    {
        return optime;
    }
    public void setOptime(String optime)
    {
        this.optime = optime;
    }
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    
    

}
