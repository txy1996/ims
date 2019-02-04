package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: WxOrdersResponseList
 * @Description: TODO(微信:订单)
 * @author tangxiaoyu
 * @date 2018年8月21日 上午10:39:12
 *
 */
@Data
public class WxOrdersResponseList implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer oid;// 订单id
//    private Integer sid;//商户id
    private String sname;//商户名称
    private String odate;// 下单时间
    private Integer onum;// 购买数量
    private Double omoney;// 金额
    private String money;//总金额
    private Integer ostae;// 订单状态
    private String img;// 图片地址
    private String onoun;// 订单号
    private String pid;//商品id集合

    private List<String> imgs;//图片地址





}
