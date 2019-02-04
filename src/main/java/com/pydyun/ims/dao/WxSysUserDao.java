package com.pydyun.ims.dao;

import com.pydyun.ims.model.Sys_User;

/**
 * @ClassName: WxSysUserDao
 * @Description: TODO(微信:用户信息)
 * @author tangxiaoyu
 * @date 2018年8月13日 上午11:25:44
 *
 */
public interface WxSysUserDao
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
