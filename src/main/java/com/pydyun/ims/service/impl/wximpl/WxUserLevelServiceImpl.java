package com.pydyun.ims.service.impl.wximpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxUserLevelDao;
import com.pydyun.ims.service.wxservice.WxUserLevelService;

/**
 * @ClassName: WxUserLevelServiceImpl
 * @Description: TODO(积分等级)
 * @author tangxiaoyu
 * @date 2018年8月9日 上午9:18:02
 *
 */
@Service
public class WxUserLevelServiceImpl implements WxUserLevelService
{

    @Resource
    private WxUserLevelDao WxUserLevelDao;

    @Override
    public String findUserLevelByIntegrals(Integer integrals)
    {
        // TODO Auto-generated method stub
        return WxUserLevelDao.findUserLevelByIntegrals(integrals);
    }

}
