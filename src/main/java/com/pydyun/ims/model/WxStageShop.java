package com.pydyun.ims.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangxiaoyu
 * @ClassName: WxStageShop
 * @Description: TODO(微信 : 阶段所包含的商家)
 * @date 2018年8月17日 上午11:17:17
 */

@Data
public class WxStageShop implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;
    private Integer sid;// 商家id
    private String sname;// 商家名称
    private String stel;// 联系方式
    private String saddress;// 地址
    private List<WxStageShopProduct> products;// 商品




}
