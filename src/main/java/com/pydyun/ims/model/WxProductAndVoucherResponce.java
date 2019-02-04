package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangxiaoyu
 * @ClassName: WxProductAndVoucherResponce
 * @Description: TODO(微信 : 商品和代金券返回封装类)
 * @date 2018年8月22日 下午3:30:33
 */
@Data
public class WxProductAndVoucherResponce implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer id;//商品或代金券id
    private String name;//商品或代金券名称
    private Double price;//商品或代金券价格
    private Double yprice;//商品或代金券价格
    private String status;//商品或代金券状态
    private Integer type;//代金券或商品
    private Integer isrm;//是否评论
    private String imgurl;//图片路径
    private String attributes;//属性
    private Integer num;//数量
    private Double amount;//金额


}
