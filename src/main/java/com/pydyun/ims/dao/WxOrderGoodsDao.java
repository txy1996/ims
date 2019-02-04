package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxOrderGoods;

/**
 * @ClassName: WxOrderGoodsDao
 * @Description: TODO(订单所含商品)
 * @author tangxiaoyu
 * @date 2018年8月23日 上午9:51:51
 *
 */
public interface WxOrderGoodsDao
{

    Integer saveWxOrderGoods(@Param("list") List<WxOrderGoods> list);

    Integer deleteWxOrderGoods(@Param("oids") List<Integer> oids);

    Integer updateWxOrderGoods(WxOrderGoods wxOrderGoods);

    Integer findWxOrderGoodsByIds(@Param("oids") List<Integer> oids);
}
