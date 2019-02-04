package com.pydyun.ims.service.wxservice;

import com.pydyun.ims.model.WxOrderPay;

/**
 * @ClassName: WxOrderPayService
 * @Description: TODO(微信:订单支付记录)
 * @author tangxiaoyu
 * @date 2018年8月23日 上午10:39:52
 *
 */
public interface WxOrderPayService
{
    Integer saveWxOrderPay(WxOrderPay wxOrderPay);
}
