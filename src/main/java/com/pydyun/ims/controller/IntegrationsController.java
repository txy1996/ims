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
import com.pydyun.ims.model.Integrations;
import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.service.GoogAndIntegrationItemService;
import com.pydyun.ims.service.IntegrationsService;
import com.pydyun.ims.service.UserService;

@Controller
@RequestMapping("/integral")
public class IntegrationsController
{
    @Resource
    private IntegrationsService IntegrationsService;

    @Resource
    private UserService userService;

    @Resource
    private GoogAndIntegrationItemService googAndIntegrationItemService;

    // 积分管理
    @RequiresPermissions("integral:list")
    @RequestMapping("/list")
    public ModelAndView selectintegrations(Integer pageNum, Integer pageSize, PointsGoldCoinsRequest request)
    {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<Integrations> list = IntegrationsService.selectintegrations(pageNum, pageSize, request);
        GoogAndIntegrationItem item = new GoogAndIntegrationItem();
        item.setIgori(0L);
        request.setUsername(userService.findname(request.getUrid()));
        List<GoogAndIntegrationItem> googAndIntegration = googAndIntegrationItemService.select(item);
        ModelAndView mv = new ModelAndView("integra/integrations");
        mv.addObject("list", list);
        mv.addObject("request", request);
        mv.addObject("googAndIntegration", googAndIntegration);
        return mv;
    }

    // 删除
    @RequiresPermissions("integral:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(Integer iid)
    {
        IntegrationsService.delete(iid);
    }

    @RequiresPermissions("integral:add")
    @RequestMapping("/add")
    @ResponseBody
    public Integrations addIntegrations(Integer urid, Integer igetnum, String igetinfo)
    {

        Integrations integrations = new Integrations();
        integrations.setUrid(urid);
        integrations.setIgetnum(igetnum);
        integrations.setIgetinfo(igetinfo);
        integrations.setIsum(IntegrationsService.seleteNum(urid) + (igetnum));

        IntegrationsService.addIntegrations(integrations);

        return integrations;

    }

}
