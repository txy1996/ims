package com.pydyun.ims.controller.wxcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydyun.ims.dao.WxUserCartDao;
import com.pydyun.ims.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pydyun.ims.service.wxservice.WxOrdersService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangxiaoyu
 * @ClassName: WxOrdersController
 * @Description: TODO(微信 : 订单)
 * @date 2018年8月21日 下午12:01:50
 */
@RestController
@RequestMapping("/wxOrders")
public class WxOrdersController
{

    @Resource
    private WxOrdersService wxOrdersService;

    @Resource
    private WxUserCartDao wxUserCartDao;

    @RequestMapping("/findWxOrdersList")
    public List<WxOrdersResponseList> findWxOrdersList(Integer pageNum, Integer pageSize, WxOrders wxOrders) {
//        pageNum = pageNum == null ? 1 : pageNum;
//        pageSize = pageSize == null ? 6 : pageSize;

        return wxOrdersService.findWxOrdersList(wxOrders);

    }

    @RequestMapping("/getWxOrdersList")
    public WxOrdersDetailsResponse getWxOrdersList(String onoun) {
        WxOrdersDetailsResponse response= wxOrdersService.getWxOrdersList(onoun);

        return response;

    }

    @RequestMapping("/deleteWxOrders")
    public Integer deleteWxOrders(String onoun) {


        return wxOrdersService.deleteWxOrders(onoun);

    }

    @RequestMapping("/updateWxOrders")
    public Integer updateWxOrders(WxOrders wxOrders) {


        return wxOrdersService.updateWxOrders(wxOrders);

    }

    /**
     * @Title: saveWxOrders
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: [request, response]
     * @return:com.pydyun.ims.model.WxUserCart
     * @Date: 2018/8/25 18:54
     */
    @RequestMapping("/saveWxOrders")
    @Transactional
    public List<WxOrders> saveWxOrders(WxOrdersAddRequest wxOrdersAddRequest) {

        /*购物车数据转换*/
        Gson gson = new Gson();
        List<WxUserCart> list = gson.fromJson(wxOrdersAddRequest.getWxUserCartJson(), new TypeToken<List<WxUserCart>>()
        {
        }.getType());
//        List<Integer> ids = new ArrayList<>();
//        if (wxOrdersAddRequest.getShoppingCartId() != "undefined" && wxOrdersAddRequest.getShoppingCartId() != null) {
        /*购物车id集合转换*/
        List<Integer> ids = gson.fromJson(wxOrdersAddRequest.getShoppingCartId(), new TypeToken<List<Integer>>()
        {
        }.getType());
//        }


        List<UserOrderMessage> omsgs = gson.fromJson(wxOrdersAddRequest.getOmsgJson(), new TypeToken<List<UserOrderMessage>>()
        {
        }.getType());
        wxOrdersAddRequest.setWxUserCarts(list);
        wxOrdersAddRequest.setOmsgs(omsgs);
        List<WxOrders> wxOrders = wxOrdersService.saveWxOrders(wxOrdersAddRequest);
        if (ids != null) {
            wxUserCartDao.deleteWxUserCart(ids);
        }

        return wxOrders;

    }
}
