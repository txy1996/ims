package com.pydyun.ims.dao;

import com.pydyun.ims.model.WxOrderPay;

/**
 * @ClassName: WxOrderPayDao
 * @Description: TODO(微信:订单支付)
 * @author tangxiaoyu
 * @date 2018年8月23日 上午10:29:24
 *
 */
public interface WxOrderPayDao
{
    Integer saveWxOrderPay(WxOrderPay wxOrderPay);

}
