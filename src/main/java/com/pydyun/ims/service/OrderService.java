package com.pydyun.ims.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.*;

public interface OrderService
{
    PageInfo<Order> getAllMsg(Integer pageNum, Integer pageSize, Map<String, Object> map);

    void updateOrder(OrderRequest order);

    Order selectMessage(int id);

    void deleteOrder(int id);

    /*订单列表*/
    PageInfo<OrderResponse> findOrderAll(Integer pageNum, Integer pageSize, OrderRequest request);



    /*订单详情*/
    OrderInfoResponse findOrderInfo(Integer oid);

    /*订单下商品*/
    List<OrderProductResponse> findOrderProductByOid(Integer oid);

    /*订单下代金券*/
    List<OrderProductResponse> findOrderVoucherByOid(Integer oid);


}
