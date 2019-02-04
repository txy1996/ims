package com.pydyun.ims.model;

import lombok.Data;

/**
 * FileName: OrderProductResponse
 * Author:   tangxiaoyu
 * Date:     2018/9/18 11:25
 * Description: TODO(订单下商品返回封装类)
 *
 * @since 1.0.0
 */
@Data
public class OrderProductResponse
{

    private Integer id;//商品id
    private String pname;//商品名称
    private Double price;//商品原价
    private Double yprice;//商品优惠价
    private Integer ognum;//商品数量
    private Double ogmoney;//商品总金额
    private String url;//商品图片路径
}
