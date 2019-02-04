package com.pydyun.ims.model;

import lombok.Data;

import java.util.Date;

/**
 * FileName: OrderRequest
 * Author:   tangxiaoyu
 * Date:     2018/9/17 16:12
 * Description: TODO(订单请求封装类)
 *
 * @since 1.0.0
 */
@Data
public class OrderRequest
{

    private Integer oid;// 购买代金券优惠券的订单id
    private Integer urid; // 用户id
    private Integer cid;// 公司id
    private Date odate;// 下单购买时间
    private Integer onum;// 购买数量
    private Integer opaytype;// 支付方式0:货到付款 1:在线支付
    private Integer opaymodel;// 支付来源1:支付宝，2：微信,3：金币
    private Integer oispay;// 是否支付状态(0未支付、1已支付、2未接受、3已接受、4退款中、5退款成功、6申请退款)
    private Integer ogetintegration;// 本订单所获得积分
    private Double omoney;// 订单总金额
    private Integer ogoods;// 所需金币
    private Integer oisinvoice;// 是否需要发票
    private Integer ostae;// 订单状态(0下单，1支付，2取消，3关闭)
    private String onoinfo;// 非成功的原因
    private Integer oshfs;// 收货方式(0电子，1快递，2自提)
    private String oshname;// 收货人名字
    private String oshtel;// 收货人联系电话
    private String oshaddress;// 收货人地址
    private String oexpress;// 快递公司
    private String oexpresssn;// 快递单号
    private String onoun;// 所属批次号
    private Double ofreight;// 运费
    private String oinfo;//订单备注
    private String omsg;//用户留言
}
