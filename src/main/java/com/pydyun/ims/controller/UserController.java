package com.pydyun.ims.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Role;
import com.pydyun.ims.model.User;
import com.pydyun.ims.model.UserPageResponse;
import com.pydyun.ims.service.RoleService;
import com.pydyun.ims.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController
{
    protected Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    /*
     * @RequiresPermissions("user:show")
     * @RequestMapping("/list")
     * public ModelAndView showUserList(Integer pageNum, Integer pageSize,String
     * words) {
     * pageNum = pageNum == null ? 1 : pageNum;
     * pageSize = pageSize == null ? 8 : pageSize;
     * words = "".equals(words)?null : words;
     * PageInfo<User> users = userService.getAllUsersAndRoles(pageNum,
     * pageSize,words);
     * ModelAndView mav = new ModelAndView("module/user-list");
     * mav.addObject("users", users);
     * return mav;
     * }
     */

    @RequiresPermissions("user:add")
    @RequestMapping("/add")
    @ResponseBody
    public User addUser(User user, Long... roleIds)
    {
        Date date = new Date();
        user.setCreateTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式（用于日志输出）
        userService.addUser(user, roleIds);
        logger.info("添加新用户：" + user.getUsername() + "，时间：" + sdf.format(date));
        return user;
    }

    // 检测用户是否有权限（此方法不可加@RequiresPermissions）
    @RequestMapping("/checkRoles")
    @ResponseBody
    public Integer checkRoles(String username)
    {
        List<Role> roleList = roleService.getRolesByUsername(username);
        if (roleList.size() == 0)
        {
            logger.error("检测到用户名：" + username + "没有角色及权限!");
            return 0;
        }
        else
        {
            return 1;
        }
    }

    @SuppressWarnings("rawtypes")
	@RequiresPermissions("user:show")
    @RequestMapping("/showRoles")
    @ResponseBody
    public List showRoles(String username)
    {
        return roleService.getRolesByUsername(username);
    }

    @RequiresPermissions("user:show")
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(String username)
    {
        return userService.getUserByUsername(username);
    }

    @SuppressWarnings("rawtypes")
	@RequestMapping("/listRoles")
    @ResponseBody
    public List getRoles()
    {
        return roleService.getAllRoles();
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public void deleteUser(Long userId)
    {
        userService.deleteUser(userId);
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("/deleteMore")
    @ResponseBody
    public void deleteMoreUsers(Long... userIds)
    {
        userService.deleteMoreUsers(userIds);
    }

    @RequiresPermissions("user:update")
    @RequestMapping("/update")
    @ResponseBody
    public void updateUser(User user, Long... roleIds)
    {
        userService.updateUser(user, roleIds);
    }

    @RequiresPermissions("user:reset")
    @RequestMapping("/resetPassword")
    @ResponseBody
    public void resetPassword(String username)
    {
        logger.info("正在重置用户" + username + "的密码。");
        userService.resetPassword(username);
    }

    /**
     * @Title: select
     * @Description: TODO(用户管理分页查询)
     * @param pageNum
     * @param pageSize
     * @param Userattribute
     * @param userinfo
     * @return
     * @throws UnsupportedEncodingException 
     */
    @RequiresPermissions("user:show")
    @RequestMapping("/list")
    public ModelAndView select(Integer pageNum, Integer pageSize, String Userattribute, String userinfo,String filter, Integer minNum,
            Integer maxNum) throws UnsupportedEncodingException
    {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        Userattribute = Userattribute == null ? "Undefined" : Userattribute;
        userinfo = userinfo == null ? "Undefined" : userinfo;
        userinfo = new String(userinfo .getBytes("iso8859-1"),"utf-8"); 
        filter = filter == null ? "filter" : filter;
        maxNum = maxNum == null ? -1 : maxNum;
        minNum = minNum == null ? -1 : minNum;
        PageInfo<UserPageResponse> users = userService.select(pageNum, pageSize, Userattribute, userinfo,filter, minNum, maxNum);
        ModelAndView mav = new ModelAndView("module/user-list");
        mav.addObject("users", users);
        return mav;
    }

   
}
