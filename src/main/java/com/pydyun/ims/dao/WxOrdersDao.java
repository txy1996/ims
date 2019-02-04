package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxOrders;
import com.pydyun.ims.model.WxOrdersResponse;
import com.pydyun.ims.model.WxOrdersResponseList;
import com.pydyun.ims.model.WxProductAndVoucherResponce;

/**
 * @ClassName: WxOrdersDao
 * @Description: TODO(微信:订单)
 * @author tangxiaoyu
 * @date 2018年8月21日 上午10:53:23
 *
 */
public interface WxOrdersDao
{

    /**
     * @Title: findWxOrdersList
     * @Description: TODO(订单列表)
     * @param wxOrders
     * @return
     */
    List<WxOrdersResponseList> findWxOrdersList(WxOrders wxOrders);

    /**
     * @Title: getWxOrdersList
     * @Description: TODO(订单详情)
     * @param onoun
     * @return
     */
    List<WxOrdersResponse> getWxOrdersList(String onoun);

    /**
     * @Title: getWxOrdersProduct
     * @Description: TODO(订单下商品)
     * @param oid
     * @return
     */
    List<WxProductAndVoucherResponce> getWxOrdersProduct(Integer oid);

    /**
     * @Title: getWxOrdersVoucher
     * @Description: TODO(订单下代金券)
     * @param oid
     * @return
     */
    List<WxProductAndVoucherResponce> getWxOrdersVoucher(Integer oid);

    Integer saveWxOrders(@Param("list") List<WxOrders> wxOrders);

    Integer updateWxOrders(@Param("list") List<Integer> oids,@Param("ostae")Integer ostae);

    Integer deleteWxOrders(String onoun);

    List<Integer> findWxOrdersOid(String onoun);

}
