package com.pydyun.ims.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.pydyun.ims.model.*;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.OrderDAO;
import com.pydyun.ims.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService
{
    @Resource
    private OrderDAO orderDao;

    @Override
    public PageInfo<Order> getAllMsg(Integer pageNum, Integer pageSize, Map<String, Object> map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> order = orderDao.queryAll(map);
        return new PageInfo<>(order);
    }

    @Override
    public Order selectMessage(int id) {
        Order order = orderDao.queryById(id);
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        orderDao.delteOrderById(id);
    }

    @Override
    public PageInfo<OrderResponse> findOrderAll(Integer pageNum, Integer pageSize, OrderRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        if (request.getOshtel() == null || request.getOshtel().isEmpty()) {
            request.setOshtel(null);
        }
        if (request.getOexpresssn() == null || request.getOexpresssn().isEmpty()) {
            request.setOexpresssn(null);
        }
        List<OrderResponse> responses = orderDao.findOrderAll(request);
        return new PageInfo<>(responses);
    }

    @Override
    public OrderInfoResponse findOrderInfo(Integer oid) {
        return orderDao.findOrderInfoByOid(oid);
    }

    @Override
    public List<OrderProductResponse> findOrderProductByOid(Integer oid) {
        return orderDao.findOrderProductByOid(oid);
    }

    @Override
    public List<OrderProductResponse> findOrderVoucherByOid(Integer oid) {
        return orderDao.findOrderVoucherByOid(oid);
    }

    @Override
    public void updateOrder(OrderRequest order) {
        orderDao.updateOrderById(order);
    }

}
