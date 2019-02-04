package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxUserAndPositionDao;
import com.pydyun.ims.model.WxUserAndPosition;
import com.pydyun.ims.service.wxservice.WxUserAndPositionService;

/**
 * @ClassName: WxUserAndPositionServiceImpl
 * @Description: TODO(微信:用户和公司发票职位关系)
 * @author tangxiaoyu
 * @date 2018年8月13日 上午11:14:23
 *
 */
@Service
public class WxUserAndPositionServiceImpl implements WxUserAndPositionService
{
    @Resource
    private WxUserAndPositionDao WxUserAndPositionDao;

    @Override
    public Integer saveWxUserAndPosition(WxUserAndPosition userAndPosition)
    {
        // TODO Auto-generated method stub
        return WxUserAndPositionDao.saveWxUserAndPosition(userAndPosition);
    }

    @Override
    public List<WxUserAndPosition> findWxUserAndPosition(WxUserAndPosition userAndPosition)
    {
        // TODO Auto-generated method stub
        return WxUserAndPositionDao.findWxUserAndPosition(userAndPosition);
    }

    @Override
    public Integer deleteWxUserAndPosition(Integer upid)
    {
        // TODO Auto-generated method stub
        return WxUserAndPositionDao.deleteWxUserAndPosition(upid);
    }

    @Override
    public Integer updateWxUserAndPosition(WxUserAndPosition userAndPosition)
    {
        // TODO Auto-generated method stub
        return WxUserAndPositionDao.updateWxUserAndPosition(userAndPosition);
    }

}
