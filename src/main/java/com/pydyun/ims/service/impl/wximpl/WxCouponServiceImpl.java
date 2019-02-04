package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxCouponDao;
import com.pydyun.ims.model.WxCouponResponse;
import com.pydyun.ims.service.wxservice.WxCouponService;

/**
 * @author tangxiaoyu
 * @ClassName: WxCouponServiceImpl
 * @Description: TODO(微信 : 用户优惠券记录)
 * @date 2018年8月8日 下午2:40:41
 */
@Service
public class WxCouponServiceImpl implements WxCouponService
{

    @Resource
    private WxCouponDao WxCouponDao;

    @Override
    public List<WxCouponResponse> findCouponByUrid(Integer urid) {
        // TODO Auto-generated method stub
        return WxCouponDao.findCouponByUrid(urid);
    }

    @Override
    public List<WxCouponResponse> findCouponInvalidByUrid(Integer urid) {
        // TODO Auto-generated method stub
        return WxCouponDao.findCouponInvalidByUrid(urid);
    }

    @Override
    public Integer getCouponCountByUrid(Integer urid) {
        return WxCouponDao.getCouponCountByUrid(urid);
    }

}
