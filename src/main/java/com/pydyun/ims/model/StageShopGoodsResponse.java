package com.pydyun.ims.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: StageShopGoodsResponse
 * Author:   tangxiaoyu
 * Date:     2018/9/26 17:37
 * Description: TODO(阶段下商户商品信息)
 *
 * @since 1.0.0
 */
@Data
public class StageShopGoodsResponse
{

    private Integer ssid;// 阶段id
    private Integer sid;//商户id
    private String sname;//商户名称
    private String slogo;//商户logo
    private String stel;//订餐联系方式（文本框50字）
    private String scommerce;//商务洽谈联系方式
    private String saddress;//地址
    private List<StageGoodsResponse> stageGoodsResponses;
}
