package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.GoogAndIntegrationItem;
import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.model.Slintegration;
import com.pydyun.ims.service.GoogAndIntegrationItemService;
import com.pydyun.ims.service.ShopService;
import com.pydyun.ims.service.SlintegrationService;

/**
 * @ClassName: SlintegrationController
 * @Description: TODO(商户积分)
 * @author tangxiaoyu
 * @date 2018年7月12日 上午9:50:50
 *
 */
@Controller
@RequestMapping("/slintegration")
public class SlintegrationController
{

    @Resource
    private SlintegrationService SlintegrationService;

    @Resource
    private ShopService shopService;

    @Resource
    private GoogAndIntegrationItemService googAndIntegrationItemService;

    /**
     * @Title: selectSlintegration
     * @Description: TODO(分页条件查询)
     * @param pageNum
     * @param pageSize
     * @param request 积分金币查询封装类
     * @return
     */
    @RequiresPermissions("slintegration:list")
    @RequestMapping("/list")
    public ModelAndView selectSlintegration(Integer pageNum, Integer pageSize, PointsGoldCoinsRequest request)
    {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;

        PageInfo<Slintegration> list = SlintegrationService.selectSlintegration(pageNum, pageSize, request);
        GoogAndIntegrationItem item = new GoogAndIntegrationItem();
        item.setIgori(0L);
        List<GoogAndIntegrationItem> googAndIntegration = googAndIntegrationItemService.select(item);
        Shop shop = new Shop();
        request.setSid(1);
        if (request.getSid() != null)
        {
            shop = shopService.getByShopId(request.getSid());
            request.setSname(shop.getSname());
        }
        ModelAndView mv = new ModelAndView("integra/slintegration");
        mv.addObject("list", list);
        mv.addObject("request", request);
        mv.addObject("googAndIntegration", googAndIntegration);
        return mv;
    }

    /**
     * @Title: addSlintegration
     * @Description: TODO(新增商户积分记录)
     * @param sid
     * @param sgetnum
     * @param sgetinfo
     */
    @RequiresPermissions("slintegration:add")
    @RequestMapping("/add")
    @ResponseBody
    public Slintegration addSlintegration(Integer sid, Integer sgetnum, String sgetinfo)
    {

        Slintegration slintegration = new Slintegration();
        slintegration.setSid(sid);
        slintegration.setSgetnum(sgetnum);
        slintegration.setSgetinfo(sgetinfo);
        slintegration.setSsum(SlintegrationService.seleteNum(sid) + (sgetnum));

        SlintegrationService.addSlintegration(slintegration);
        return slintegration;

    }

    @RequiresPermissions("slintegration:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(Integer slid)
    {
        SlintegrationService.delete(slid);
    }
}
