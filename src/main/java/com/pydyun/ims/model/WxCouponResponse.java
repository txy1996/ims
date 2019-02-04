package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangxiaoyu
 * @ClassName: WxCouponResponse
 * @Description: TODO(微信端, 用户优惠券返回封装类)
 * @date 2018年8月8日 下午2:21:35
 */
@Data
public class WxCouponResponse implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private String ctitle;// 优惠券标题
    private String cimg;// 优惠券图片地址
    private String crange;// 适用商户（全站all、品牌p:1,2,3、单店s：1，2,3），不可将品牌、店铺做混合插入
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date csdate;// 生效日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date codate;// 失效日期
    private Double cdiscount;// 折扣率(88.88)
    private Double csum;// 金额(50)
    private String cfullcut;// 满减[100,10]、啤酒一箱、内容自定义
    private Integer ucstate;// 失效方式
    private String OfferContent;//优惠内容


}
