package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ProfuctResponse
 * @Description: TODO(商品编辑返回封装)
 * @author tangxiaoyu
 * @date 2018年7月26日 下午3:44:28
 *
 */
@Data
public class ProductUpdateResponse implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer id;// 商品编号
    private String pname;// 商品名称
    private Integer cid;// 所属分类
    private String cname;// 所属分类名称
    private String ptyid;// 属性id
    private String ptyname;// 属性名称
    private Integer sid;// 商家编号
    private Integer spunum;// 销量
    private Integer stock;// 库存
    private String pcode;// 商品编号
    private String property;// 商品属性表 property 的ID序列 例如 [1:1,2:3]
    private Double price;// 售价(原价)
    private Double yprice;// 优惠售价
    private String info;// 商品详情
    private Integer state;// 商品状态 0=未上架，1=上架，2=下架，3=？？

    private String sname;// 商户名称
    private Integer imgid;// 图片id
    private String url;// 图片地址
    private String imgname;// 图片名称

    private String ptitle;// 副标题， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private String psad;// 商品广告词， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private String sparefieldone;
    private String sparefieldtwo;
    private String sparefieldthree;
    


}
