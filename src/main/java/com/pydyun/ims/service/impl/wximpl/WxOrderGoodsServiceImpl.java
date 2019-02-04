package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxOrderGoodsDao;
import com.pydyun.ims.model.WxOrderGoods;
import com.pydyun.ims.service.wxservice.WxOrderGoodsService;

/**
 * @ClassName: WxOrderGoodsServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangxiaoyu
 * @date 2018年8月23日 上午10:16:48
 *
 */
@Service
public class WxOrderGoodsServiceImpl implements WxOrderGoodsService
{

    @Resource
    private WxOrderGoodsDao WxOrderGoodsDao;

    @Override
    public Integer saveWxOrderGoods(List<WxOrderGoods> wxOrderGoods)
    {
        // TODO Auto-generated method stub
        return WxOrderGoodsDao.saveWxOrderGoods(wxOrderGoods);
    }

    @Override
    public Integer deleteWxOrderGoods(List<Integer> oids)
    {
        // TODO Auto-generated method stub
        return WxOrderGoodsDao.deleteWxOrderGoods(oids);
    }

    @Override
    public Integer updateWxOrderGoods(WxOrderGoods wxOrderGoods)
    {
        // TODO Auto-generated method stub
        return WxOrderGoodsDao.updateWxOrderGoods(wxOrderGoods);
    }

}
