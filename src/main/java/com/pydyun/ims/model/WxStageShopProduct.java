package com.pydyun.ims.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author tangxiaoyu
 * @ClassName: WxStageShopProduct
 * @Description: TODO(微信 : 个人方案所含的商家下面所包含的商品)
 * @date 2018年8月17日 上午11:20:59
 */
@Data
public class WxStageShopProduct implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer pid;// 商品id
    private Integer cid;// 商品分类id
    private String pname;// 商品名称
    private Double price;// 商品价格
    private Integer pnum;// 商品数量
    private String pimg;//商品图片


}
