package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.pydyun.ims.model.WxCouponResponse;

/**
 * @ClassName: WxCouponService
 * @Description: TODO(微信:用户优惠券记录)
 * @author tangxiaoyu
 * @date 2018年8月8日 下午2:39:46
 *
 */
public interface WxCouponService
{

    /**
     * @Title: findCouponByUrid
     * @Description: TODO(根据用户id查询优惠券,有效)
     * @param urid
     * @return
     */
    List<WxCouponResponse> findCouponByUrid(Integer urid);

    /**
     * @Title: findCouponInvalidByUrid
     * @Description: TODO(根据用户id查询优惠券,无效)
     * @param urid
     * @return
     */
    List<WxCouponResponse> findCouponInvalidByUrid(Integer urid);

    /*统计有效优惠券*/
    Integer getCouponCountByUrid(Integer urid);
}
