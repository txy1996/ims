package com.pydyun.ims.controller;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.LoginLog;
import com.pydyun.ims.service.LoginLogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/loginLog")
public class LoginLogController {
    protected Logger logger = LogManager.getLogger(this.getClass());
    @Resource
    private LoginLogService loginLogService;

    @RequiresPermissions("loginLog:show")
    @RequestMapping("/list")
    public ModelAndView showLoginLogList(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<LoginLog> loginLogs = loginLogService.getAllLoginLog(pageNum, pageSize);
        ModelAndView mav = new ModelAndView("module/login-log");
        mav.addObject("loginLogs", loginLogs);
        return mav;
    }

    @RequiresPermissions("loginLog:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public void deleteLoginLog(Long id) {
        loginLogService.deleteLoginLog(id);
    }

    @RequiresPermissions("loginLog:delete")
    @RequestMapping("/deleteMore")
    @ResponseBody
    public void deleteMoreLoginLog(Long... ids) {
        loginLogService.deleteMoreLoginLog(ids);
    }
}