package com.pydyun.ims.model;

import lombok.Data;

import java.util.List;

/**
 * FileName: WxOrdersAddRequest
 * Author:   tangxiaoyu
 * Date:     2018/9/2 9:43
 * Description: TODO(订单新增封装类)
 *
 * @since 1.0.0
 */
@Data
public class WxOrdersAddRequest
{

    private Integer urid;//用户id
    private Integer oisinvoice;//是否需要发票
    private String oshname;//收货人名称
    private String oshtel;//收获人电话
    private String oshaddress;//收货人地址
    private String wxUserCartJson;//json字符信息
    private String omsgJson;//用户留言json信息
    private String shoppingCartId;//购物车id
    List<WxUserCart> wxUserCarts;//购物车商品
    List<UserOrderMessage> omsgs;//用户留言

}
