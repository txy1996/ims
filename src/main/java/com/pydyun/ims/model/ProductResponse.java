package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ProductResponse 
 * @Description: TODO(商品分页查询返回封装类) 
 * @author tangxiaoyu 
 * @date 2018年7月25日 下午4:33:39 
 *
 */
@Data
public class ProductResponse implements Serializable
{

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */ 
    private static final long serialVersionUID = 1L;
    
    private Integer id;// 商品编号
    private String pname;// 商品名称
    private Integer cid;// 所属分类
    private String cname;//分类名称
    private Integer sid;// 商家编号
    private String sname;//商家名称
    private Integer spunum;// 销量
    private Integer stock;// 库存
    private Integer state;// 商品状态 0=未上架，1=上架，2=下架，3=？？
    private String ptitle;// 副标题， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private String psad;// 商品广告词， 也可根据产品特性作他用，但切记后台添加和前台显示要匹配
    private String sparefieldone;
    private String sparefieldtwo;
    private String sparefieldthree;
    

    
    
    
    
    
    

}
