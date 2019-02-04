package com.pydyun.ims.service.impl.wximpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxSysUserDao;
import com.pydyun.ims.model.Sys_User;
import com.pydyun.ims.service.wxservice.WxSysUserService;

/**
 * @ClassName: WxSysUserServiceImpl
 * @Description: TODO(微信:个人中心-用户信息)
 * @author tangxiaoyu
 * @date 2018年8月13日 下午1:53:24
 *
 */
@Service
public class WxSysUserServiceImpl implements WxSysUserService
{

    @Resource
    private WxSysUserDao WxSysUserDao;

    @Override
    public Integer saveWxSysUser(Sys_User user)
    {
        // TODO Auto-generated method stub
        return WxSysUserDao.saveWxSysUser(user);
    }

    @Override
    public Sys_User findWxSysUser(Sys_User user)
    {
        // TODO Auto-generated method stub
        return WxSysUserDao.findWxSysUser(user);
    }

    @Override
    public Integer updateWxSysUser(Sys_User user)
    {
        // TODO Auto-generated method stub
        return WxSysUserDao.updateWxSysUser(user);
    }

    @Override
    public Sys_User findWxSysUserByWxOpenId(String wx_OpenId)
    {
        // TODO Auto-generated method stub
        return WxSysUserDao.findWxSysUserByWxOpenId(wx_OpenId);
    }

}
