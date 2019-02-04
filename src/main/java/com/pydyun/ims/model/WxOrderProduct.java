package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangxiaoyu
 * @ClassName: WxOrderProduct
 * @Description: TODO(微信 : 订单 - 商品)
 * @date 2018年8月23日 下午12:15:18
 */
@Data
public class WxOrderProduct implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer id;// 商品id
    private Integer sid;// 商家id
    private Double yprice;// 优惠价格
    private Double price;// 价格
    private Integer type;//0商品,1代金券
    private Integer state;// 状态
    private Integer pxd;// 本产品是否想允许使用优惠券、代金券
    private Double freight;// 商品运费
    private Double fgxf;// 运费续费
    private Integer fgtype;// 运费计价方式
    private Integer num;// 数量
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date stime;//预定开始时间  主要场地类用
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date otime;//预定结束时间  主要场地类用
    private Integer pnum;//预定人数 主要场地类用


}
