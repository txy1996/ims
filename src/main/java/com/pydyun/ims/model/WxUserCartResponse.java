package com.pydyun.ims.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * FileName: WxUserCartResponse
 * Author:   tangxiaoyu
 * Date:     2018/8/27 13:49
 * Description: TODO(微信:购物车返回封装类)
 *
 * @since 1.0.0
 */
@Data
public class WxUserCartResponse
{

    private Integer id;//购物车记录id
    private Integer uid;// 用户id
    private Integer oid;// 商品或代金券id
    private Integer cid;// 商品分类id
    private Integer otype;// 类型 0=商品，1=代金券
    private Integer num;// 数量
    private Integer status;// 状态，0=勾选，1=未勾选 勾选就可以进入下一步生成订单，不勾选则不能进入生成订单环节
    private Integer sid;//商户id
    private String sname;//商户名称
    private String pname;//商品名称
    private Double price;//商品价格
    private Double yprice;//商品优惠价格
    private Integer pstatus;//
    private String imgurl;//图片地址
    private Double freight;//运费
    private Double fgxf;//续费
    private Integer fgtype;//运费计价方式

}
