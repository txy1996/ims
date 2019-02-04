package com.pydyun.ims.model;

import lombok.Data;

/**
 * FileName: ProductInfoResponse
 * Author:   tangxiaoyu
 * Date:     2018/9/21 15:29
 * Description: TODO(方案中商品信息)
 *
 * @since 1.0.0
 */
@Data
public class ProductInfoResponse
{

    private Integer id;//商品id
    private String pname;//商品名称
    private Integer cid;//商品分类id
    private Integer sid;//商户id
    private Double price;//价格
    private Double yprice;//原价格
    private String url;//图片地址
    private String sname;//商户名称
    private String stel;//联系方式

}
