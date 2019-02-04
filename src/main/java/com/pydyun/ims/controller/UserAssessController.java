package com.pydyun.ims.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.UserAssessPageResponse;
import com.pydyun.ims.service.UserAssessService;

/**
 * @ClassName: UserAssessController
 * @Description: TODO(用户评论表前端控制器)
 * @author tangxiaoyu
 * @date 2018年7月11日 上午11:29:40
 *
 */
@Controller
@RequestMapping("/userAssess")
public class UserAssessController
{

    @Resource
    private UserAssessService userAssessService;

    @RequiresPermissions("userAssess:list")
    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView select(Integer pageNum, Integer pageSize,UserAssessPageResponse response)
    {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 20 : pageSize;
        PageInfo<UserAssessPageResponse> list =userAssessService.select(pageNum, pageSize, response);
        ModelAndView mv = new ModelAndView("userAssess/userAssess");
        mv.addObject("list", list);
        mv.addObject("response", response);
        return mv;

    }
}
