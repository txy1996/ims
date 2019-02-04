package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangxiaoyu
 * @ClassName: ProductRequest
 * @Description: TODO(商品查询封装类)
 * @date 2018年7月25日 下午4:08:43
 */
@Data
public class ProductRequest
{

    private String pname;// 商品名称
    private String cname;//分类名称;
    private Integer pcid;// 所属分类id
    private Integer sid;// 商家编号
    private Integer stock;// 库存
    private String sname;//商品名称
    private Integer state;// 商品状态 0=未上架，1=上架，2=下架，3=？？
    private String ptitle;// 副标题， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private String psad;// 商品广告词， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private String sparefieldone;
    private String sparefieldtwo;
    private String sparefieldthree;


}
