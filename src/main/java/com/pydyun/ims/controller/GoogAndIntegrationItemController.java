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
import com.pydyun.ims.service.GoogAndIntegrationItemService;

/**
 * @ClassName: GoogAndIntegrationItemController
 * @Description: TODO(积分金币操作项前端控制器)
 * @author tangxiaoyu
 * @date 2018年7月21日 下午10:47:01
 *
 */
@RequestMapping("/giitem")
@Controller
public class GoogAndIntegrationItemController
{

    @Resource
    GoogAndIntegrationItemService itemService;

    /**
     * @Title: selectPage
     * @Description: TODO(积分金币操作项分页条件查询)
     * @param pageNum
     * @param pageSize
     * @param item
     * @return
     */
    @RequiresPermissions("giitem:list")
    @RequestMapping("/list")
    public ModelAndView selectPage(Integer pageNum, Integer pageSize, GoogAndIntegrationItem item)
    {

        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<GoogAndIntegrationItem> list = itemService.selectPage(pageNum, pageSize, item);
        ModelAndView mv = new ModelAndView("integra/goog_integration_item");
        mv.addObject("list", list);
        return mv;

    }

    /**
     * @Title: updateGoogAndIntegrationItem
     * @Description: TODO(修改积分金币操作项)
     * @param item
     */

    @RequestMapping("/update")
    @ResponseBody
    public GoogAndIntegrationItem updateGoogAndIntegrationItem(GoogAndIntegrationItem item)
    {
        itemService.updateGoogAndIntegrationItem(item);
        return item;
    }

    /**
     * @Title: deleteById
     * @Description: TODO(删除积分金币操作项)
     * @param id
     */

    @RequestMapping("/delete")
    @ResponseBody
    public Integer deleteById(Integer id)
    {
        return itemService.deleteById(id);
    }

    /**
     * @Title: addGoogAndIntegrationItem
     * @Description: TODO(新增积分金币操作项)
     * @param item
     */

    @RequestMapping("/add")
    @ResponseBody
    public GoogAndIntegrationItem addGoogAndIntegrationItem(GoogAndIntegrationItem item)
    {
        itemService.addGoogAndIntegrationItem(item);
        return item;
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<GoogAndIntegrationItem> select(GoogAndIntegrationItem item)
    {
        return itemService.select(item);
    }

    @RequestMapping("/selectItemXML")
    @ResponseBody
    public List<GoogAndIntegrationItem> selectItemXML()
    {

        return itemService.selectItemXML();
    }
}
