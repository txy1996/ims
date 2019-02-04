package com.pydyun.ims.service.wxservice;

import com.pydyun.ims.model.Sys_User;

/**
 * @ClassName: WxSysUserService
 * @Description: TODO(微信:个人中心-用户信息)
 * @author tangxiaoyu
 * @date 2018年8月13日 下午1:52:15
 *
 */
public interface WxSysUserService
{

    /**
     * @Title: saveWxSysUser
     * @Description: TODO(微信:新增用户信息)
     * @param user
     * @return
     */
    Integer saveWxSysUser(Sys_User user);

    /**
     * @Title: findWxSysUser
     * @Description: TODO(微信:查询用户信息)
     * @param user
     * @return
     */
    Sys_User findWxSysUser(Sys_User user);

    /**
     * @Title: updateWxSysUser
     * @Description: TODO(微信:修改用户信息)
     * @param user
     * @return
     */
    Integer updateWxSysUser(Sys_User user);
    
    /**
     * @Title: findWxSysUserByWxOpenId 
     * @Description: TODO(根据wx_OpenId查询) 
     * @param wx_OpenId
     * @return
     */
    Sys_User findWxSysUserByWxOpenId(String wx_OpenId);
}
