package com.pydyun.ims.dao;

import java.util.List;
import java.util.Map;

import com.pydyun.ims.model.*;
import org.apache.ibatis.annotations.Param;

public interface OrderDAO
{
    List<Order> queryAll(Map<String, Object> map);

    void updateOrderById(OrderRequest order);

    Order queryById(int id);

    void delteOrderById(int id);

    /*订单列表*/
    List<OrderResponse> findOrderAll(OrderRequest request);

    /*订单详情*/
    OrderInfoResponse findOrderInfoByOid(@Param("oid") Integer oid);

    /*订单下商品*/
    List<OrderProductResponse> findOrderProductByOid(@Param("oid") Integer oid);

    /*订单下代金券*/
    List<OrderProductResponse> findOrderVoucherByOid(@Param("oid") Integer oid);


}
