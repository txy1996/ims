package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Goods_user;
import com.pydyun.ims.model.GoogAndIntegrationItem;
import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.service.Goods_userService;
import com.pydyun.ims.service.GoogAndIntegrationItemService;
import com.pydyun.ims.service.UserService;

@Controller
@RequestMapping("/goods_user")
public class Goods_userController
{
    @Resource
    private Goods_userService Goods_userService;

    @Resource
    private UserService userService;

    @Resource
    private GoogAndIntegrationItemService googAndIntegrationItemService;

    // 用户金币管理
    @RequiresPermissions("goods_user:list")
    @RequestMapping("/list")
    public ModelAndView usermoney(Integer pageNum, Integer pageSize, PointsGoldCoinsRequest request)
    {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<Goods_user> list = Goods_userService.usermoney(pageNum, pageSize, request);
        request.setUsername(userService.findname(request.getUrid()));
        GoogAndIntegrationItem item = new GoogAndIntegrationItem();
        item.setIgori(1L);
        List<GoogAndIntegrationItem> googAndIntegration = googAndIntegrationItemService.select(item);
        ModelAndView mv = new ModelAndView("integra/goods_user");
        mv.addObject("list", list);
        mv.addObject("request", request);
        mv.addObject("googAndIntegration", googAndIntegration);
        return mv;
    }

    // 删除
    @RequiresPermissions("goods_user:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(Integer gid)
    {
        Goods_userService.delete(gid);
    }

    /**
     * @Title: saveGoodsUser
     * @Description: TODO(新增金币日志)
     * @param goods_user
     */
    @RequiresPermissions("goods_user:add")
    @RequestMapping("/add")
    @ResponseBody
    public Goods_user saveGoodsUser(Integer urid, Integer gonum, String goinfo)
    {

        Goods_user goods_user = new Goods_user();
        goods_user.setUrid(urid);
        goods_user.setGoinfo(goinfo);
        goods_user.setGonum(gonum);
        goods_user.setGnum(Goods_userService.seleteNum(urid) + (gonum));
        Goods_userService.saveGoodsUser(goods_user);

        return goods_user;
    }
}
