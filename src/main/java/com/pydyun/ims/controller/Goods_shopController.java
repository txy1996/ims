package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Goods_shop;
import com.pydyun.ims.model.GoogAndIntegrationItem;
import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.service.Goods_shopService;
import com.pydyun.ims.service.GoogAndIntegrationItemService;
import com.pydyun.ims.service.ShopService;

/**
 * @ClassName: Goods_shopController
 * @Description: TODO(商户金币)
 * @author tangxiaoyu
 * @date 2018年8月1日 下午2:02:59
 *
 */
@Controller
@RequestMapping("/goods_shop")
public class Goods_shopController
{
    @Resource
    private Goods_shopService Goods_shopService;

    @Resource
    private ShopService shopService;

    @Resource
    private GoogAndIntegrationItemService googAndIntegrationItemService;

    // 商户金币管理
    @RequiresPermissions("goods_shop:list")
    @RequestMapping("/list")
    public ModelAndView shopmoney(Integer pageNum, Integer pageSize,PointsGoldCoinsRequest request)
    {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<Goods_shop> list = Goods_shopService.shopmoney(pageNum, pageSize, request);
        Shop shop = new Shop();
        if (request.getSid() != null)
        {
            shop = shopService.getByShopId(request.getSid());
            request.setSname(shop.getSname());
        }
        
        GoogAndIntegrationItem item = new GoogAndIntegrationItem();
        item.setIgori(1L);
        List<GoogAndIntegrationItem> googAndIntegration = googAndIntegrationItemService.select(item);
        ModelAndView mv = new ModelAndView("integra/goods_shop");
        mv.addObject("list", list);
        mv.addObject("request", request);
        mv.addObject("googAndIntegration", googAndIntegration);
        return mv;
    }

    // 删除
    @RequiresPermissions("goods_shop:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(Integer gid)
    {
        Goods_shopService.delete(gid);
    }

    // 新增商户积分
    @RequiresPermissions("goods_shop:add")
    @RequestMapping("/add")
    @ResponseBody
    public Goods_shop addshop(Goods_shop goods_shop)
    {
        Goods_shopService.addshop(goods_shop);
        return goods_shop;

    }
}
