package com.pydyun.ims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.pydyun.ims.model.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController
{
    @Resource
    private OrderService orderService;

    /**
     * 分页条件查询
     *
     * @param pageNum
     * @param pageSize
     * @param oshtel
     * @param urid
     * @param oexpresssn
     * @return
     */
    @RequiresPermissions("order:list")
    @RequestMapping("/list")
    public ModelAndView toOrder(Integer pageNum, Integer pageSize, String oshtel, String oexpresssn, String urid) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        oshtel = (oshtel == null || "".equals(oshtel)) ? null : oshtel;
        oexpresssn = (oexpresssn == null || "".equals(oexpresssn)) ? null : oexpresssn;
        urid = (urid == null || "".equals(urid)) ? null : urid;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("oshtel", oshtel);//收货人电话
        map.put("oexpresssn", oexpresssn);//快递单号
        map.put("urid", urid);
        PageInfo<Order> order = orderService.getAllMsg(pageNum, pageSize, map);
        ModelAndView mv = new ModelAndView("order/order-list");
        mv.addObject("order", order);
        mv.addObject("urid", urid);
        return mv;
    }

    @RequiresPermissions("order:update")
    @RequestMapping("/update1")
    @ResponseBody
    public void updateOrder(OrderRequest request) {

        orderService.updateOrder(request);
    }

    @RequiresPermissions("order:list")
    @RequestMapping("/getOrder")
    @ResponseBody
    public Order getInfo(String id) {
        return orderService.selectMessage(Integer.valueOf(id));
    }

    @RequiresPermissions("order:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public void deleteOrder(String id) {
        orderService.deleteOrder(Integer.valueOf(id));
    }

    @RequiresPermissions("order:findOrderAll")
    @RequestMapping("/findOrderAll")
    public ModelAndView findOrderAll(Integer pageNum, Integer pageSize, OrderRequest request) throws Exception {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        if (request != null) {
            DataProcessing(request);
        }
        PageInfo<OrderResponse> responsePageInfo = orderService.findOrderAll(pageNum, pageSize, request);
        ModelAndView mv = new ModelAndView("order/order");
        mv.addObject("order", responsePageInfo);
        mv.addObject("request", request);
        return mv;
    }

    @RequestMapping("/findOrderInfo")
    @ResponseBody
    public ModelAndView findOrderInfo(Integer oid) {

        OrderInfoResponse infoResponse = orderService.findOrderInfo(oid);
        List<OrderProductResponse> productResponses = orderService.findOrderProductByOid(oid);
        List<OrderProductResponse> responses = orderService.findOrderVoucherByOid(oid);
        if (responses != null) {
            productResponses.addAll(responses);
        }
        ModelAndView mv = new ModelAndView("order/orderDetails");
        mv.addObject("orderInfo", infoResponse);
        mv.addObject("orderProduct", productResponses);
        return mv;
    }

    /*订单数据处理*/
    private OrderRequest DataProcessing(OrderRequest request) throws Exception {
        if (request.getOshtel() != null) {
            request.setOshtel(new String(request.getOshtel().getBytes("iso8859-1"), "utf-8"));
        }
        if (request.getOexpresssn() != null) {
            request.setOexpresssn(new String(request.getOexpresssn().getBytes("iso8859-1"), "utf-8"));
        }
        if (request.getOstae() == null || request.getOstae() == -1) {
            request.setOstae(null);
        }
        if (request.getOstae() != null && request.getOstae() == -1) {
            request.setOstae(null);
        }
        if (request.getOisinvoice() != null && request.getOisinvoice() == -1) {
            request.setOisinvoice(null);
        }
        return request;
    }
}
