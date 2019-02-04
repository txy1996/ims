package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: ProductAddRequest 
 * @Description: TODO(商品新增封装类) 
 * @author tangxiaoyu 
 * @date 2018年7月26日 下午2:40:50 
 *
 */
@Data
public class ProductAddRequest
{
    
    private Integer id;// 商品编号
    private String pname;// 商品名称
    private Integer cid;// 所属分类
    private Integer sid;// 商家编号
    private Integer spunum;// 销量
    private Integer stock;// 库存
    private String pcode;// 商品编号
    private String property;// 商品属性表 property 的ID序列 例如 [1:1,2:3]
    private Double price;// 售价(原价)
    private Double yprice;// 优惠售价
    private String info;// 商品详情
    private Integer state;// 商品状态 0=未上架，1=上架，2=下架，3=？？
    private String ptitle;// 副标题， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private String psad;// 商品广告词， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private Integer pxd;//本产品是否想允许使用优惠券、代金券 0=不限制，都可以用 1=不适用优惠券，但可以使用代金券 2=不适用代金券，但可以使用优惠券 12=两种券都不允许
    private Double freight;//商品的运费，首重/首件.
    private Double fg_xf;//续费，从第二件开始的续费，比如每增加一件就多二元钱
    private Integer fg_type;//运费计价方式0=按单计算，则无论买多少，运费都不变1=多件续费，比如首件10元，续费2元用户购买3件的计算公式为 10+2*3
    private Date stime;//注册时间
    private Date sutime;//最近一次更新时间
    private Integer imgid;
    private String url;
    private String imgname;
    private String sparefieldone;
    private String sparefieldtwo;
    private String sparefieldthree;

    
    

}
