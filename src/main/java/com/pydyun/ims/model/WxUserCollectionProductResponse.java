package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: WxUserCollectionProductResponse
 * @Description: TODO(微信:个人中心-我的收藏-商品返回封装类)
 * @author tangxiaoyu
 * @date 2018年8月9日 上午11:31:06
 *
 */
@Data
public class WxUserCollectionProductResponse
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer ucid;// 收藏ID
    private Integer urid;// 用户ID
    private Integer oid;// 对象ID
    private Integer cid;//商品分类id
    private Integer otype;// 对象类型 0=商户，1=商品，2=代金券，4….
    private Integer uctype;// 具体操作 0=使用，1=收藏，2=赞，3=踩，4=01,5=02,6=03,7=12,8=13
    private String ucdate;// 更改操作时间
    private String pname;// 商品名称
    private Double price;// 商品原价
    private Double yprice;// 商品优惠价
    private String state;// 商品状态
    private String url;// 商品图片
    private String ptitle;// 商品副标题
    private String psad;// 商品广告词


}
