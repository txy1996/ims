package com.pydyun.ims.model;

import lombok.Data;

/**
 * FileName: StageGoodsResponse
 * Author:   tangxiaoyu
 * Date:     2018/9/26 15:54
 * Description: TODO(阶段中商品)
 *
 * @since 1.0.0
 */
@Data
public class StageGoodsResponse
{

    private Integer ssid;// 阶段id
    private Integer id;//商品id
    private String pname;//商品名称
    private Integer cid;//分类id
    private Integer sid;//商户id
    private String sname;//商户名称
    private Double price;//价格
    private Double yprice;//原价
    private String url;//图片地址
    private String slogo;//商户logo
    private String stel;//商户联系方式
    private String saddress;//商户地址
    private String scommerce;//商户联系方式
    private Integer num;//商品数量


}
