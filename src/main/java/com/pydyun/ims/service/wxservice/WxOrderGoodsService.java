package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.pydyun.ims.model.WxOrderGoods;

/**
 * @ClassName: WxOrderGoodsService 
 * @Description: TODO(微信:订单下商品) 
 * @author tangxiaoyu 
 * @date 2018年8月23日 上午10:16:08 
 *
 */
public interface WxOrderGoodsService
{

    Integer saveWxOrderGoods(List<WxOrderGoods> wxOrderGoods);

    Integer deleteWxOrderGoods(List<Integer> oids);

    Integer updateWxOrderGoods(WxOrderGoods wxOrderGoods);
}
