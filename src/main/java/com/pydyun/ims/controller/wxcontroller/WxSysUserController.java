package com.pydyun.ims.controller.wxcontroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pydyun.ims.model.Sys_User;
import com.pydyun.ims.model.WxCompany;
import com.pydyun.ims.model.WxUserAndPosition;
import com.pydyun.ims.service.wxservice.WxSysUserService;
import com.pydyun.ims.util.MD5Encryption;

/**
 * @author tangxiaoyu
 * @ClassName: WxSysUserController
 * @Description: TODO(微信 : 个人中心 - 用户信息)
 * @date 2018年8月13日 下午1:55:31
 */
@Controller
@RequestMapping("/wxSysUser")
public class WxSysUserController
{

    @Resource
    private WxSysUserService wxSysUserService;

    @RequestMapping("/findWxSysUser")
    @ResponseBody
    public Sys_User findWxSysUser(Sys_User user) {


        return wxSysUserService.findWxSysUser(user);
    }

    @RequestMapping("/updateWxSysUser")
    @ResponseBody
    public Sys_User updateWxSysUser(Sys_User user) {


        if (user.getPassword() != null) {
            user = MD5Encryption.encryptPassword(user);
        }
        wxSysUserService.updateWxSysUser(user);
        return wxSysUserService.findWxSysUser(user);
    }

}
