package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.*;

public interface WxOrdersService
{

    /**
     * @param wxOrders
     * @return
     * @Title: findWxOrdersList
     * @Description: TODO(订单列表)
     */
    List<WxOrdersResponseList> findWxOrdersList(WxOrders wxOrders);

    /**
     * @param onoun
     * @return
     * @Title: getWxOrdersList
     * @Description: TODO(订单详情)
     */
    WxOrdersDetailsResponse getWxOrdersList(String onoun);

    List<WxOrders> saveWxOrders(WxOrdersAddRequest wxOrdersAddRequest);

    Integer updateWxOrders(WxOrders wxOrders);

    Integer deleteWxOrders(String onoun);


}
