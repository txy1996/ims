package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: WxOrdersResponse
 * @Description: TODO(微信:订单详情返回封装类)
 * @author tangxiaoyu
 * @date 2018年8月22日 上午9:48:13
 *
 */
@Data
public class WxOrdersResponse
{

    private Integer oid;// 购买代金券优惠券的订单id
    private Integer urid; // 用户id
    private Integer cid;// 公司id
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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
    private String sname;// 商家名称
    private Integer sid;// 商家id
    private Double ofreight;// 运费
    private List<WxProductAndVoucherResponce> productAndVoucher;

    
    


}
