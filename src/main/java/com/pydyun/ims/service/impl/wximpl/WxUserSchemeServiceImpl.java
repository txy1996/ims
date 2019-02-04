package com.pydyun.ims.service.impl.wximpl;

import java.security.InvalidParameterException;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxUserSchemeDao;
import com.pydyun.ims.model.WxUserScheme;
import com.pydyun.ims.model.WxUserSchemerListResponse;
import com.pydyun.ims.service.wxservice.WxUserSchemeService;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserSchemeServiceImpl
 * @Description: TODO(用户收藏方案)
 * @date 2018年8月17日 上午10:25:47
 */
@Service
public class WxUserSchemeServiceImpl implements WxUserSchemeService
{

    @Resource
    private WxUserSchemeDao wxUserSchemeDao;

    @Override
    public Integer saveWxUserScheme(WxUserScheme userScheme) throws Exception{
        if(userScheme==null){
            throw new InvalidParameterException("收藏的方案信息不能为空");
        }
        return wxUserSchemeDao.saveWxUserScheme(userScheme);
    }

    @Override
    public Integer updateWxUserScheme(WxUserScheme userScheme) {
        // TODO Auto-generated method stub
        return wxUserSchemeDao.updateWxUserScheme(userScheme);
    }

    @Override
    public Integer deleteWxUserScheme(Integer usuid, Integer ussid) {
        // TODO Auto-generated method stub
        return wxUserSchemeDao.deleteWxUserScheme(usuid, ussid);
    }

    @Override
    public PageInfo<WxUserSchemerListResponse> findWxUserScheme(Integer pageNum, Integer pageSize, WxUserScheme userScheme) {
        PageHelper.startPage(pageNum,pageSize);
        List<WxUserSchemerListResponse> listResponses = wxUserSchemeDao.findWxUserScheme(userScheme);

        return new PageInfo<>(listResponses);
    }

    @Override
    public WxUserScheme getWxUserScheme(Integer usid) {
        // TODO Auto-generated method stub
        return wxUserSchemeDao.getWxUserScheme(usid);
    }

    @Override
    public Integer getWxUserSchemePresence(Integer usuid, Integer ussid) {
        return wxUserSchemeDao.getWxUserSchemePresence(usuid, ussid);
    }

}
