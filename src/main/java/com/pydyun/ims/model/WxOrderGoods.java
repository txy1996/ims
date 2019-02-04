package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangxiaoyu
 * @ClassName: WxOrderGood
 * @Description: TODO(订单所含商品)
 * @date 2018年8月23日 上午9:45:12
 */
@Data
public class WxOrderGoods
{


    private Integer ogid;// 记录ID
    private Integer oid;// 所属订单ID
    private Integer vid;// 商品、券ID
    private Integer vtype;// 类型 0=商品，1=代金券，2=优惠券，3=
    private Integer ognum;// 购买数量
    private Double ogmoney;// 本商品总金额
    private Integer isrm;//是否评论,0=未，1=已评论
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date stime;//预定开始时间  主要场地类用
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date otime;//预定结束时间  主要场地类用
    private Integer pnum;//预定人数 主要场地类用


}
